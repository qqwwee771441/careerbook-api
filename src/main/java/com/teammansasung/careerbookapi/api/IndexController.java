package com.teammansasung.careerbookapi.api;

import com.teammansasung.careerbookapi.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 인증이 필요하지 않는 기본 API들
 */
@RequiredArgsConstructor
@RestController
public class IndexController {
    /**
     * 쿠키: 클라이언트 저장소
     * 세션: 서버 저장소
     */
    private final HttpSession httpSession; // 세션

    /**
     * 현재 로그인 상태인지 확인
     * 세션 저장소에 user 변수가 존재하면 로그인 상태
     * @return 로그인 상태면 유저 email 응답, 아니면 null 응답
     */
    @GetMapping("/status")
    public String status() {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            return user.getEmail();
        }
        return null;
    }
}
