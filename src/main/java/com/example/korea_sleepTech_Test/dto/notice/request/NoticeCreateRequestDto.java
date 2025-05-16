package com.example.korea_sleepTech_Test.dto.notice.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeCreateRequestDto {
    @NotNull
    private String title;

    @NotNull
    private String content;
}