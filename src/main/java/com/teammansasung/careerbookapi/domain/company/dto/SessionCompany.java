package com.teammansasung.careerbookapi.domain.company.dto;

import com.teammansasung.careerbookapi.domain.company.Company;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionCompany implements Serializable {
    private String id;
    private String companyRegistrationNumber;

    public SessionCompany(Company company) {
        this.id = company.getUid();
        this.companyRegistrationNumber = company.getCompanyRegistrationNumber();
    }
}
