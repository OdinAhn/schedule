package com.schedule.controller;

import com.schedule.dto.*;
import com.schedule.entity.Schedule;
import com.schedule.service.CommentService;
import com.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        CreateScheduleResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // Search ALL -> 작성자명 조건 검색 기능
    @GetMapping("/schedules")
    public ResponseEntity<List<GetOneScheduleResponse>> getAllSchedules(
            @RequestParam(required = false) String name) {
        List<GetOneScheduleResponse> result = scheduleService.getAll(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // Search One
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetOneScheduleResponse> getSchedule(@PathVariable Long scheduleId) {
        GetOneScheduleResponse result = scheduleService.getOne(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // Update
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleRequest request) {

        UpdateScheduleResponse result = scheduleService.updateSchedule(scheduleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // Delete -> Password 검증
    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long scheduleId,
            @RequestBody PasswordRequest passwordRequest
            )
    {
        scheduleService.deleteSchedule(scheduleId,passwordRequest.getPassword());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
