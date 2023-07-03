package com.teammansasung.careerbookapi.domain.company.service.impl;

import com.teammansasung.careerbookapi.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyDetailsServiceImpl implements UserDetailsService {
    private final CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return companyRepository.getByUid(username);
    }
}
