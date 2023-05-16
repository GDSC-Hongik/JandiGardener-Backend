package com.gdschongik.gardener.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @CreationTimestamp
    private LocalDateTime registeredAt;

    @OneToOne(mappedBy = "registration")
    private ChallengeHistory challengeHistory;

    @Builder
    public Registration(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public static Registration createRegistration(LocalDateTime registeredAt) {
        return Registration.builder()
                .registeredAt(registeredAt)
                .build();
    }
}
