package com.example.korea_sleepTech_Test.service;

import com.example.korea_sleepTech_Test.dto.user.request.UserSignInRequestDto;
import com.example.korea_sleepTech_Test.dto.user.request.UserSignUpRequestDto;
import com.example.korea_sleepTech_Test.dto.user.response.UserSignInResponseDto;
import com.example.korea_sleepTech_Test.dto.user.response.UserSignUpResponseDto;
import com.example.korea_sleepTech_Test.dto.response.ResponseDto;

public interface AuthService {
    ResponseDto<UserSignUpResponseDto> signUp(UserSignUpRequestDto dto);
    ResponseDto<UserSignInResponseDto> signIn(UserSignInRequestDto dto);
}