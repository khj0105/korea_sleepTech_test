package com.example.korea_sleepTech_Test.controller;

import com.example.korea_sleepTech_Test.common.ApiMappingPattern;
import com.example.korea_sleepTech_Test.dto.response.ResponseDto;
import com.example.korea_sleepTech_Test.dto.user.request.UserSignInRequestDto;
import com.example.korea_sleepTech_Test.dto.user.request.UserSignUpRequestDto;
import com.example.korea_sleepTech_Test.dto.user.response.UserSignUpResponseDto;
import com.example.korea_sleepTech_Test.dto.user.response.UserSignInResponseDto;
import com.example.korea_sleepTech_Test.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiMappingPattern.AUTH_API)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private static final String POST_SIGN_UP = "/signup";
    private static final String POST_SIGN_IN = "/login";

    @PostMapping(POST_SIGN_UP)
    public ResponseEntity<ResponseDto<UserSignUpResponseDto>> signUp(@Valid @RequestBody UserSignUpRequestDto dto) {
        ResponseDto<UserSignUpResponseDto> response = authService.signUp(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(POST_SIGN_IN)
    public ResponseEntity<ResponseDto<UserSignInResponseDto>> signIn(@Valid @RequestBody UserSignInRequestDto dto) {
        ResponseDto<UserSignInResponseDto> response = authService.signIn(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}