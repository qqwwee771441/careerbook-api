package com.teammansasung.careerbookapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Careerbook 어플리케이션 시작
 */
@SpringBootApplication
public class CareerbookApiApplication {

    public static void main(String[] args) {
        /**
         * 내장 톰캣 서버 실행 및 유지
         * 이후 외부에서 http (get post put delete) 요청시, url 매핑된 controller 또는 rest controller 호출
         * 브라우저에서 http://localhost:8080 주소 입력시 default controller에 의해 index.html 응답
         */
        SpringApplication.run(CareerbookApiApplication.class, args);
    }

}
