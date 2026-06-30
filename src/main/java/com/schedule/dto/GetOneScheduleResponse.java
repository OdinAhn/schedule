package com.schedule.dto;

import com.schedule.entity.Comment;
import com.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter

public class GetOneScheduleResponse {
    private final Long id;
    private final String subject;
    private final String content;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    private final List<CreateCommentResponse> comments;

    // 너무 기니까 Schedule 엔티티 통째로 가져오자
    public GetOneScheduleResponse(Schedule schedule, List<CreateCommentResponse> comments) {
        this.id = schedule.getId();
        this.subject = schedule.getSubject();
        this.content = schedule.getContent();
        this.name = schedule.getName();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();

        this.comments = comments;
    }

    // 단건 조회용 파라미터 여러개 받아서 of -> 댓글도 같이 조회
    public static GetOneScheduleResponse of(Schedule schedule, List<Comment> comments) {
        List<CreateCommentResponse> commentResponses = comments.stream()
                .map(CreateCommentResponse::new)
                .collect(Collectors.toList());

        return new GetOneScheduleResponse(schedule, commentResponses);
    }
    // 전체 조회용 from -> 빈 리스트가 들어간다, 댓글 없음
    public static GetOneScheduleResponse from(Schedule schedule) {
        return new GetOneScheduleResponse(schedule, List.of());
    }

}