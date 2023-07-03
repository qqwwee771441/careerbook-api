package com.teammansasung.careerbookapi.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanySignInRequestDto {
    String username;
    String password;
}
