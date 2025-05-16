package com.example.korea_sleepTech_Test.dto.user.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignInRequestDto {
    @NotNull
    private String username;

    @NotNull
    private String password;
}