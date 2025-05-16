package com.example.korea_sleepTech_Test.dto.user.response;

import com.example.korea_sleepTech_Test.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserSignUpResponseDto {
    User user;
}
