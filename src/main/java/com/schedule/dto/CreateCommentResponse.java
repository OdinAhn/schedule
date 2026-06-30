package com.schedule.dto;

import com.schedule.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor // 변수가 많아지니까 그냥 AllArgsConstructor 쓰자
public class CreateCommentResponse {
    private final Long id;
    private final Long scheduleId; // 일정 고유식별자ID

    private final String content;
    private final String name;

    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    // AllArgsConstructor 그냥 쓸려고 했는데 엔티티 통째로 받는거 계속 써보고 싶어서 그냥 다시 생성자 만들자
    public CreateCommentResponse(Comment comment) {
        this.id = comment.getId();
        this.scheduleId = comment.getScheduleId();
        this.content = comment.getContent();
        this.name = comment.getName();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();

    }
}


