package com.gdschongik.gardener.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String handle;

    private String githubId;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<History> histories = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Reward> rewards = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Registration> registrations = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime lastLoginAt;

    @Builder
    public User(String name, String handle, String githubId, LocalDateTime createdAt, LocalDateTime lastLoginAt) {
        this.name = name;
        this.handle = handle;
        this.githubId = githubId;
        this.createdAt = createdAt;
        this.lastLoginAt = lastLoginAt;
    }

    public static User createUser(String name, String handle, String githubId) {
        return User.builder()
                .name(name)
                .handle(handle)
                .githubId(githubId)
                .build();
    }
}