package com.teammansasung.careerbookapi.api;

import com.teammansasung.careerbookapi.domain.user.Role;
import com.teammansasung.careerbookapi.domain.user.User;
import com.teammansasung.careerbookapi.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 테스트를 위한 컨트롤러
 * 자유롭게 작성 가능
 */
@RequiredArgsConstructor
@RestController
public class TestController {
    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    /**
     * User 데이터베이스 객체
     */
    private final UserRepository userRepository;

    /**
     * http://localhost:8080/test/add
     * 데이터베이스 연결 확인 테스트
     * 데이터베이스 종류: mariadb
     * 데이터베이스 이름: careerbook
     * 포트: resoucres/application.properties 파일에서 3307로 설정되어 있음.
     * 해당 함수 실행이후 데이터베이스 mariadb/careerbook에 user항목 하나가 저장되어야 함.
     * @return 웹브라우저에서 complete 메시지가 출력
     */
    @GetMapping("/test/add")
    public String add() {
        LOGGER.info("add 메서드 호출");
        User user = new User("name", "email", "picture", Role.USER);
        userRepository.save(user);
        LOGGER.info("add 메서드 new user 그리고 complete 반환");
        return "complete";
    }

    @GetMapping("/api/v1/auth")
    public Authentication auth() {
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }
}
