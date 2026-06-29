package com.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleRequest {

    private String subject;
    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
