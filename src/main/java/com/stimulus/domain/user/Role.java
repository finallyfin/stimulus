package com.stimulus.domain.user;

// 각 사용자의 권한을 관리할 Enum클래스 Role을 생성함

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

    /* 스프링 시큐리티에서는 권한코드 앞에 항상 ROLE_이 있어야만 합니다. */

}