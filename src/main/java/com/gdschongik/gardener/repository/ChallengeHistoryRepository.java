package com.gdschongik.gardener.repository;

import com.gdschongik.gardener.domain.ChallengeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeHistoryRepository extends JpaRepository<ChallengeHistory, Long> {
}
