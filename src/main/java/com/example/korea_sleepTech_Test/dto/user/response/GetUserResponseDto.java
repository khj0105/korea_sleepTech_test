package com.example.korea_sleepTech_Test.dto.user.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto {
    private Long id;
    private String username;
    private String role;
}