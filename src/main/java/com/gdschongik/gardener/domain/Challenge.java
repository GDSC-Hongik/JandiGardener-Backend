package com.gdschongik.gardener.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private String description;

    private String bannerUrl;

    @Builder
    public Challenge(String name, LocalDateTime startAt, LocalDateTime endAt, String description, String bannerUrl) {
        this.name = name;
        this.startAt = startAt;
        this.endAt = endAt;
        this.description = description;
        this.bannerUrl = bannerUrl;
    }

    public static Challenge createChallenge(String name, LocalDateTime startAt, LocalDateTime endAt, String description, String bannerUrl) {
        return Challenge.builder()
                .name(name)
                .startAt(startAt)
                .endAt(endAt)
                .description(description)
                .bannerUrl(bannerUrl)
                .build();
    }
}
