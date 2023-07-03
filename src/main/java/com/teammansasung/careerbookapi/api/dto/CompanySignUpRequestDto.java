package com.teammansasung.careerbookapi.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanySignUpRequestDto {
    String businessRegistrationNumber;
    String username;
    String password;
}
