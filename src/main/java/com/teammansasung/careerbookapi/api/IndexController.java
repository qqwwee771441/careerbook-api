package com.teammansasung.careerbookapi.api;

import com.teammansasung.careerbookapi.config.auth.LoginCompany;
import com.teammansasung.careerbookapi.config.auth.LoginUser;
import com.teammansasung.careerbookapi.config.auth.dto.SessionUser;
import com.teammansasung.careerbookapi.domain.company.dto.SessionCompany;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 인증이 필요하지 않는 기본 API들
 */
@RequiredArgsConstructor
@RestController
public class IndexController {
    private final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
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
    @GetMapping("/api/status")
    public int status(@LoginUser SessionUser user, @LoginCompany SessionCompany company) {
        LOGGER.info("status 메서드 호출");
        if (user != null) {
            LOGGER.info("status 메서드 login user true code 반환");
            return 1;
        }
        if (company != null) {
            LOGGER.info("status 메서드 login company true code 반환");
            return 2;
        }
        LOGGER.info("status 메서드 null 반환");
        return 0;
    }
}
