package com.example.korea_sleepTech_Test.dto.user.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpRequestDto {
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;
}