package com.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class CreateScheduleResponse {
    private final Long id;
    private final String subject;
    private final String content;
    private final String name;
    private final String password;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CreateScheduleResponse(Long id, String subject, String content, String name, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.name = name;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
