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
        Comment comment = new Comment(
                request.getScheduleId(),
                request.getContent(),
                request.getName(),
                request.getPassword()


        );
        Comment savedComment = commentRepository.save(comment);

        return new CreateCommentResponse(
                savedComment.getId(),
                savedComment.getScheduleId(),
                savedComment.getContent(),
                savedComment.getName(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt()

        );
    }


}
