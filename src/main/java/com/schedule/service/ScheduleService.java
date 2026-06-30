package com.schedule.service;

import com.schedule.dto.*;
import com.schedule.entity.Comment;
import com.schedule.entity.Schedule;
import com.schedule.repository.CommentRepository;
import com.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository; // 단 건 조회시 댓글도 같이 나와야해서

    //Create
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getSubject(),
                request.getContent(),
                request.getName(),
                request.getPassword()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getSubject(),
                savedSchedule.getContent(),
                savedSchedule.getName(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()

        );
    }

    //Search All
    @Transactional(readOnly = true)
    public List<GetOneScheduleResponse> getAll(String name) {
        List<Schedule> schedules;

        // 내림차순 조건 처리
        if (name != null && !name.trim().isEmpty()) {
            schedules = scheduleRepository.findAllByNameOrderByModifiedAtDesc(name);
        } else {
            schedules = scheduleRepository.findAllByOrderByModifiedAtDesc();
        }

        return schedules.stream()
                .map(GetOneScheduleResponse::from)
                .collect(Collectors.toList());

        /*
        return schedules.stream()
                .map(
                        schdule -> new GetOneScheduleResponse(
                                schdule.getId(),
                                schdule.getSubject(),
                                schdule.getContent(),
                                schdule.getName(),
                                schdule.getCreatedAt(),
                                schdule.getModifiedAt()
                        )
                )
                .toList();

         */

    }

    // Search One
    @Transactional(readOnly = true)
    public GetOneScheduleResponse getOne(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("일정이 존재하지 않습니다")
        );
        // 일정 단건 조회 할때 댓글도 같이 조회되게 추가

        List<Comment> comments = commentRepository.findByScheduleId(scheduleId);

        return GetOneScheduleResponse.of(schedule, comments);
    }

    // Update
    @Transactional
    public UpdateScheduleResponse updateSchedule(Long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("일정이 존재하지 않습니다.")
        );

        schedule.updateSchedule(
                request.getSubject(),
                request.getName(),
                request.getPassword()
        );

        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getSubject(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void deleteSchedule(Long scheduleId, String password) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("일정이 존재하지 않습니다.")
        );

        schedule.checkPassword(password);
        // 스케줄이 있으면 삭제
        scheduleRepository.deleteById(scheduleId);
    }


}
