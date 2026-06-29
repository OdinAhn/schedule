package com.schedule.dto;

import lombok.Getter;

@Getter

public class CreateScheduleRequest {
    private String subject;
    private String content;
    private String name;
    private String password;

}
