package com.example.korea_sleepTech_Test.dto.user.response;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class UserSignInResponseDto {
    private String token;
    private Long expirationTime;
    private int exprTime;
}