package com.teammansasung.careerbookapi.config.auth.dto;

import com.teammansasung.careerbookapi.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * 서버의 세션 저장소에 저장할 user 클래스
 * 세선에 저장하기 위해선 Serializable 해야한다.
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
