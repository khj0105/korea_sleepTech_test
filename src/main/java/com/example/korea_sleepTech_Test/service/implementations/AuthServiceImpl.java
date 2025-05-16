package com.example.korea_sleepTech_Test.service.implementations;

import com.example.korea_sleepTech_Test.common.ResponseMessage;
import com.example.korea_sleepTech_Test.dto.response.ResponseDto;
import com.example.korea_sleepTech_Test.dto.user.request.UserSignInRequestDto;
import com.example.korea_sleepTech_Test.dto.user.request.UserSignUpRequestDto;
import com.example.korea_sleepTech_Test.dto.user.response.UserSignInResponseDto;
import com.example.korea_sleepTech_Test.dto.user.response.UserSignUpResponseDto;
import com.example.korea_sleepTech_Test.entity.User;
import com.example.korea_sleepTech_Test.provider.JwtProvider;
import com.example.korea_sleepTech_Test.repository.UserRepository;
import com.example.korea_sleepTech_Test.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public ResponseDto<UserSignUpResponseDto> signUp(UserSignUpRequestDto dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            return ResponseDto.setFailed(ResponseMessage.EXIST_DATA + " (id)");
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            return ResponseDto.setFailed(ResponseMessage.NOT_MATCH_PASSWORD);
        }

        String encodedPassword = bCryptPasswordEncoder.encode(dto.getPassword());

        User newUser = User.builder()
                .username(dto.getUsername())
                .password(encodedPassword)
                .role("USER")
                .build();

        userRepository.save(newUser);

        UserSignUpResponseDto responseData = UserSignUpResponseDto.builder()
                .id(newUser.getId())
                .username(newUser.getUsername())
                .message(ResponseMessage.SUCCESS)
                .build();

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, responseData);
    }

    @Override
    public ResponseDto<UserSignInResponseDto> signIn(UserSignInRequestDto dto) {
        User user = userRepository.findByUsername(dto.getUsername())
                .orElse(null);
        if (user == null) {
            return ResponseDto.setFailed(ResponseMessage.NOT_EXISTS_USER);
        }

        if (!bCryptPasswordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return ResponseDto.setFailed(ResponseMessage.NOT_MATCH_PASSWORD);
        }

        Set<String> roles = new HashSet<>();
        roles.add(user.getRole());
        String token = jwtProvider.generateJwtToken(user.getUsername(), roles);
        Long expirationTime = (long) jwtProvider.getExpiration();

        UserSignInResponseDto responseData = new UserSignInResponseDto(token, expirationTime, ResponseMessage.SUCCESS);

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, responseData);
    }
}