package com.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class GetOneScheduleResponse {
    private final Long id;
    private final String subject;
    private final String content;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetOneScheduleResponse(Long id, String subject, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
