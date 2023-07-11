package com.teammansasung.careerbookapi.api;

import com.teammansasung.careerbookapi.config.auth.LoginCompany;
import com.teammansasung.careerbookapi.config.auth.LoginUser;
import com.teammansasung.careerbookapi.config.auth.dto.SessionUser;
import com.teammansasung.careerbookapi.domain.company.dto.SessionCompany;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/login")
    public String login() {
        return "index.html";
    }

    /*@GetMapping("/")
    public String index(@LoginUser SessionUser user, @LoginCompany SessionCompany company) {
        if (user != null) {
            return "main/personal/home.html";
        }
        else if (company != null) {
            return "main/company/home.html";
        }
        else {
            return "home_login/home.html";
        }
    }*/
}
