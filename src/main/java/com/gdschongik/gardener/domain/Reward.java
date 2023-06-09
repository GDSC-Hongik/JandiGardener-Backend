package com.gdschongik.gardener.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private String description;

    private String redeem;

    @CreationTimestamp
    private LocalDateTime receivedAt;

    @Builder
    public Reward(User user, String description, String redeem, LocalDateTime receivedAt) {
        this.user = user;
        this.description = description;
        this.redeem = redeem;
        this.receivedAt = receivedAt;
    }

    public static Reward createReward(User user, String description, String redeem, LocalDateTime receivedAt) {
        return Reward.builder()
                .user(user)
                .description(description)
                .redeem(redeem)
                .receivedAt(receivedAt)
                .build();
    }
}