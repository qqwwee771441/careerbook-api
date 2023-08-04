package com.teammansasung.careerbookapi.api;

import com.teammansasung.careerbookapi.api.dto.CompanySignInRequestDto;
import com.teammansasung.careerbookapi.api.dto.CompanySignUpRequestDto;
import com.teammansasung.careerbookapi.domain.company.dto.CompanySignInResultDto;
import com.teammansasung.careerbookapi.domain.company.dto.CompanySignUpResultDto;
import com.teammansasung.careerbookapi.domain.company.service.CompanySignService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RequiredArgsConstructor
@RestController
public class CompanySignController {
    private final Logger LOGGER = LoggerFactory.getLogger(CompanySignController.class);
    private final CompanySignService companySignService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/api/sign-in")
    public CompanySignInResultDto signIn(@RequestBody CompanySignInRequestDto resultDto) throws RuntimeException {
        LOGGER.info("sign in method called");
        String id = resultDto.getUsername();
        String password = resultDto.getPassword();

        CompanySignInResultDto companySignInResultDto = companySignService.signIn(id, password);

        LOGGER.info("sign in method return company sign in result dto");
        return companySignInResultDto;
    }

    @PostMapping("/api/sign-up")
    public CompanySignUpResultDto signUp(/*@RequestBody HashMap<String, Object> map*/ @RequestBody CompanySignUpRequestDto requestDto) {
        LOGGER.info("sign up method called");
        String id = requestDto.getUsername();
        String password = requestDto.getPassword();
        String number = requestDto.getBusinessRegistrationNumber();
        LOGGER.info("sign up method parameters: " + id + ", " + password + ", " + number);

        CompanySignUpResultDto companySignUpResultDto = companySignService.signUp(id, password, number, "ROLE_COMPANY");

        companySignService.signIn(id, password);
        LOGGER.info("sign up method return company sign up result dto");
        return companySignUpResultDto;
    }
}
