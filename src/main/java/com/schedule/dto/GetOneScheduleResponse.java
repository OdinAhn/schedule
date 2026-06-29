package com.schedule.dto;

import com.schedule.entity.Schedule;
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

    // 너무 기니까 Schudle 엔티티 통째로 가져오자
    public GetOneScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.subject = schedule.getSubject();
        this.content = schedule.getContent();
        this.name = schedule.getName();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();

        }
}
