package com.schedule.repository;

import com.schedule.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 댓글 갯수 가져와야 돼
    long countByScheduleId(Long scheduleId);
    // 댓글 목록 가져와
    // List<Comment> findByScheduleId(Long scheduleId);
}
