package com.teammansasung.careerbookapi.config.auth;

import com.teammansasung.careerbookapi.config.auth.service.CustomOAuth2UserService;
import com.teammansasung.careerbookapi.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.servlet.http.HttpSession;

/**
 * 해당 서버로 전달되는 모든 요청은 우선적으로 SecurityConfiguration의 configure에 정의된 보안 필터를 거친다.
 */
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    /**
     * 보안 필터 설정
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//.headers().frameOptions().disable()
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.and()
                .authorizeRequests()
                .antMatchers("/main/company/**").hasRole("COMPANY")
                .antMatchers("/api/v2/**").hasRole("COMPANY")
                .antMatchers("/main/personal/**").hasRole(Role.USER.name())
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .antMatchers("/", "/home_login/**", "/main/**", "/signup/**").permitAll()
                .antMatchers("/api/**", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login().loginPage("/login")
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
