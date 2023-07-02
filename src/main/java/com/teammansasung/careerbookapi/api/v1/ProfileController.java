package com.teammansasung.careerbookapi.api.v1;

import com.teammansasung.careerbookapi.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 해당 /api/v1 주소 에서는 spring security에 의해 인증된 사용자만 접근 가능
 */
@RequiredArgsConstructor
@RestController
public class ProfileController {
    private final HttpSession httpSession;

    /**
     * @return 본인 계정의 정보 name, email, picture 응답
     */
    @GetMapping("/api/v1/profile")
    public SessionUser profile() {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return user;
    }
}
