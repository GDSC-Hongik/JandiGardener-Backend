package com.gdschongik.gardener.controller;

import com.gdschongik.gardener.dto.challenge.ChallengeRegisterResponse;
import com.gdschongik.gardener.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/challenges")
public class ChallengeController {
    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @PostMapping("/{challengeId}/register")
    public ResponseEntity<ChallengeRegisterResponse> register(@PathVariable Long challengeId) {

    }
}
