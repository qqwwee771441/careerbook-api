package com.teammansasung.careerbookapi.domain.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanySignUpResultDto {
    private boolean success;
    private int code;
    private String msg;
}
