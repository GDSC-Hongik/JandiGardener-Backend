package com.gdschongik.gardener.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChallengeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Registration registration;

    private int ranking;

    private int commitCount;

    private int attendedCount;

    @Builder
    public ChallengeHistory(int ranking, int commitCount, int attendedCount) {
        this.ranking = ranking;
        this.commitCount = commitCount;
        this.attendedCount = attendedCount;
    }

    public static ChallengeHistory createChallengeHistory(int ranking, int commitCount, int attendedCount) {
        return ChallengeHistory.builder()
                .ranking(ranking)
                .commitCount(commitCount)
                .attendedCount(attendedCount)
                .build();
    }
}
