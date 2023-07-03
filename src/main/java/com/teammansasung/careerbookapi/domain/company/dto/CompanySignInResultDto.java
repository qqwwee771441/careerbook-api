package com.teammansasung.careerbookapi.domain.company.dto;

import lombok.*;
import org.springframework.security.core.Authentication;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanySignInResultDto extends CompanySignUpResultDto {
    private Authentication authentication;

    @Builder
    public CompanySignInResultDto(Boolean success, int code, String msg, Authentication authentication) {
        super(success, code, msg);
        this.authentication = authentication;
    }
}
