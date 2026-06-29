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

    public void updateSchedule(String subject, String name) {
        // 제목, 작성자만 수정가능, 비밀번호는 API 응답에서 제외
        this.subject = subject;
        this.name = name;

    }

    // 삭제할 때 password 검증 로직
    public void checkPassword(String password) {
        if (!this.password.equals(password)) { // 암호가 틀리면
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
