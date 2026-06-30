package com.schedule.repository;

import com.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // 조회 조건 추가, 작성자명이 있다면
    List<Schedule> findAllByNameOrderByModifiedAtDesc(String name);

    // 작성자명이 없다면
    List<Schedule> findAllByOrderByModifiedAtDesc();

}
