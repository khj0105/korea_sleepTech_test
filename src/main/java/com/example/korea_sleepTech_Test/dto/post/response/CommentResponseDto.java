package com.example.korea_sleepTech_Test.dto.post.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String content;
    private Long authorId;
    private String authorUsername;
}