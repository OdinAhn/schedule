package com.schedule.service;

import com.schedule.dto.*;
import com.schedule.entity.Schedule;
import com.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

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
    public List<GetOneScheduleResponse> getAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        return schedules.stream()
                .map(
                        schdule -> new GetOneScheduleResponse(
                                schdule.getId(),
                                schdule.getSubject(),
                                schdule.getContent(),
                                schdule.getName()
                        )
                )
                .toList();

    }

    // Search One
    @Transactional(readOnly = true)
    public GetOneScheduleResponse getOne(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("ID가 존재하지 않습니다")
        );
        return new GetOneScheduleResponse(
                schedule.getId(),
                schedule.getSubject(),
                schedule.getContent(),
                schedule.getName()
        );
    }

    // Update
    @Transactional
    public UpdateScheduleResponse updateSchedule(Long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("일정이 존재하지 않습니다.")
        );

        schedule.updateSchedule(
                request.getSubject(),
                request.getName()
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
    public void deleteSchedule(Long scheduleId) {
        boolean exsits = scheduleRepository.existsById(scheduleId);
        if (!exsits) { // 스케줄이 없으면
            throw new IllegalStateException("스케줄이 존재하지 않습니다.");
        }
        // 스케줄이 있으면 삭제
        scheduleRepository.deleteById(scheduleId);
    }
}
