package com.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateCommentRequest {
    private Long scheduleId; // 일정 식별자ID
    private String content;
    private String name;
    private String password;
}
