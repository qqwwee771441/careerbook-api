package com.teammansasung.careerbookapi.domain.company.service.impl;

import com.teammansasung.careerbookapi.common.CommonResponse;
import com.teammansasung.careerbookapi.config.auth.dto.SessionUser;
import com.teammansasung.careerbookapi.domain.company.Company;
import com.teammansasung.careerbookapi.domain.company.dto.CompanySignInResultDto;
import com.teammansasung.careerbookapi.domain.company.dto.CompanySignUpResultDto;
import com.teammansasung.careerbookapi.domain.company.dto.SessionCompany;
import com.teammansasung.careerbookapi.domain.company.repository.CompanyRepository;
import com.teammansasung.careerbookapi.domain.company.service.CompanySignService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CompanySignServiceImpl implements CompanySignService {
    public final CompanyRepository companyRepository;
    public final CompanyDetailsServiceImpl companyDetailsService;
    public final PasswordEncoder passwordEncoder;
    public final HttpSession httpSession;

    @Override
    public CompanySignUpResultDto signUp(String id, String password, String number, String role) {
        Company company;

        company = Company.builder()
                .uid(id)
                .companyRegistrationNumber(number)
                .password(passwordEncoder.encode(password))
                .roles(Collections.singletonList(role))
                .build();

        Company savedCompany = companyRepository.save(company);
        CompanySignUpResultDto companySignUpResultDto = new CompanySignUpResultDto();

        if (!savedCompany.getCompanyRegistrationNumber().isEmpty()) {
            setSuccessResult(companySignUpResultDto);
        }
        else {
            setFailResult(companySignUpResultDto);
        }
        return companySignUpResultDto;
    }

    @Override
    public CompanySignInResultDto signIn(String id, String password) throws RuntimeException {
        Company company = companyRepository.getByUid(id);
        if (!passwordEncoder.matches(password, company.getPassword())) {
            throw new RuntimeException();
        }

        UserDetails userDetails = companyDetailsService.loadUserByUsername(company.getUsername());
        httpSession.setAttribute("company", new SessionCompany(company));
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        CompanySignInResultDto companySignInResultDto = CompanySignInResultDto.builder()
                .authentication(authentication)
                .build();

        setSuccessResult(companySignInResultDto);

        return companySignInResultDto;
    }

    private void setSuccessResult(CompanySignUpResultDto result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    private void setFailResult(CompanySignUpResultDto result) {
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }
}
