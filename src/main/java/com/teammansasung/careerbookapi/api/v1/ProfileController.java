package com.teammansasung.careerbookapi.api.v1;

import com.teammansasung.careerbookapi.api.IndexController;
import com.teammansasung.careerbookapi.config.auth.LoginUser;
import com.teammansasung.careerbookapi.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 해당 /api/v1 주소 에서는 spring security에 의해 인증된 사용자만 접근 가능
 */
@RequiredArgsConstructor
@RestController
public class ProfileController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);
    private final HttpSession httpSession;

    /**
     * @return 본인 계정의 정보 name, email, picture 응답
     */
    @GetMapping("/api/v1/profile")
    public SessionUser profile(@LoginUser SessionUser user) {
        LOGGER.info("profile 메서드 호출");
        LOGGER.info("profile 메서드 session user 반환");
        return user;
    }
}
