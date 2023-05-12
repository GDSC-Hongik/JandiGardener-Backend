package com.gdschongik.gardener.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class History {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    private int commitCount;

    private LocalDateTime date;

    @Builder
    public History(User user, int commitCount, LocalDateTime date) {
        this.user = user;
        this.commitCount = commitCount;
        this.date = date;
    }

    public static History createHistory(User user, int commitCount, LocalDateTime date){
        return History.builder()
                .user(user)
                .commitCount(commitCount)
                .date(date)
                .build();
    }
}
