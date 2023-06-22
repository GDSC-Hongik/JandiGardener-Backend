package com.gdschongik.gardener.repository;

import com.gdschongik.gardener.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByRefreshToken(String refreshToken);

    Optional<User> findBySocialId(String socialId);
}
