package com.myeonghun.project.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//스프링 부트의 자동설정, 스프링 bean읽기와 셍성이 모두 자동설정 된다.
//항상 프로젝트 최상단에 위치
@SpringBootApplication
@EnableJpaAuditing
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
