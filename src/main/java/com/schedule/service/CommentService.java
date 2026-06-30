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

        // 댓글 10개 제한
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


}
