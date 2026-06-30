package com.schedule.controller;

import com.schedule.dto.*;
import com.schedule.repository.CommentRepository;
import com.schedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class CommentController {
    private final CommentService commentService;

    // Create
    @PostMapping("/comments")
    public ResponseEntity<CreateCommentResponse> saveComment(@RequestBody CreateCommentRequest request) {
        CreateCommentResponse result = commentService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
