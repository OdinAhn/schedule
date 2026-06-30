package com.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long scheduleId; // 일정 고유식별자ID

    private String content;
    private String name;
    private String password;

    public Comment(Long scheduleId, String content, String name, String password) {
        this.scheduleId = scheduleId;
        this.content = content;
        this.name = name;
        this.password = password;
    }
}
