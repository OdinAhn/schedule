package com.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String subject;
    private String content;
    private String name;
    private String password;

    public Schedule(String subject, String content, String name, String password) {
        this.subject = subject;
        this.content = content;
        this.name = name;
        this.password = password;
    }

    public void update(String subject, String content, String name, String password) {
        this.subject = subject;
        this.content = content;
        this.name = name;
        this.password = password;
    }
}
