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

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String email;

    private String handle;

    private String githubId;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<History> histories = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Reward> rewards = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime lastLoginAt;

    private String socialId;

    private String refreshToken;

    @Builder //TODO: 굳이 안 넣어도 될 것 같은데? 사용처가 없음
    public User(String name, UserRole role, String handle, String githubId, LocalDateTime createdAt, LocalDateTime lastLoginAt) {
        this.name = name;
        this.role = role;
        this.handle = handle;
        this.githubId = githubId;
        this.createdAt = createdAt;
        this.lastLoginAt = lastLoginAt;
    }

    public static User createUser(String name, UserRole role, String handle, String githubId) {
        return User.builder()
                .name(name)
                .role(role)
                .handle(handle)
                .githubId(githubId)
                .build();
    }

    public void authorize() {
        this.role = UserRole.USER;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}