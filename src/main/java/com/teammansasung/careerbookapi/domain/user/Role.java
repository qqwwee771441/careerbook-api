package com.teammansasung.careerbookapi.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 사용자가 가질 수 있는 권한 종류
 * GUEST 비회원
 * USER 회원
 */
@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST"),
    USER("ROLE_USER");

    private final String key;
}
