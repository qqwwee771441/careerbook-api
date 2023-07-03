package com.teammansasung.careerbookapi.domain.company.repository;

import com.teammansasung.careerbookapi.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company getByUid(String uid);
}
