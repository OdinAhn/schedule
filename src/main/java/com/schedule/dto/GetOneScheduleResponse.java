package com.schedule.dto;

import lombok.Getter;

@Getter

public class GetOneScheduleResponse {
    private final Long id;
    private final String subject;
    private final String content;
    private final String name;

    public GetOneScheduleResponse(Long id, String subject, String content, String name) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.name = name;
    }
}
