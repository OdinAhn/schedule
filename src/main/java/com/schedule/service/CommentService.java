package com.schedule.service;

import com.schedule.dto.CreateCommentRequest;
import com.schedule.dto.CreateCommentResponse;
import com.schedule.entity.Comment;
import com.schedule.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class CommentService {
    private final CommentRepository commentRepository;

    // Comment Create
    @Transactional
    public CreateCommentResponse save(CreateCommentRequest request) {

        validateCommentRequest(request);

        // 댓글 10개 제한, countBy -> DB에서 필요한 만큼만 가져오기때문에 성능상 가볍다
        long commentCount = commentRepository.countByScheduleId(request.getScheduleId());
        if (commentCount >= 10) {
            throw new IllegalArgumentException("댓글은 10개까지만 입력 가능합니다.");
        }
        Comment comment = new Comment(
                request.getScheduleId(),
                request.getContent(),
                request.getName(),
                request.getPassword()
        );
        Comment savedComment = commentRepository.save(comment);

        return new CreateCommentResponse(savedComment);

    }

    private void validateCommentRequest(CreateCommentRequest request) {
        if (request.getContent() == null || request.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("댓글 내용이 누락되었습니다.");
        }
        if (request.getContent().length() > 100) {
            throw new IllegalArgumentException("댓글 내용은 100자까지 입력 가능합니다.");
        }
        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("작성자명이 누락되었습니다.");
        }
        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("비밀번호가 누락되었습니다.");
        }
    }

}
