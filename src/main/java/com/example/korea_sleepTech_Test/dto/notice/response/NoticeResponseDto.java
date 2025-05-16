package com.example.korea_sleepTech_Test.dto.notice.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponseDto {
    private Long id;
    private String title;
    private String content;
    private Long adminId;
    private String adminUsername;
}