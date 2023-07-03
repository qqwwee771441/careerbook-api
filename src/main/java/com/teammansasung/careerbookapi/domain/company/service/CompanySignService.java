package com.teammansasung.careerbookapi.domain.company.service;

import com.teammansasung.careerbookapi.domain.company.dto.CompanySignInResultDto;
import com.teammansasung.careerbookapi.domain.company.dto.CompanySignUpResultDto;

public interface CompanySignService {
    CompanySignUpResultDto signUp(String id, String password, String name, String role);
    CompanySignInResultDto signIn(String id, String password) throws RuntimeException;
}
