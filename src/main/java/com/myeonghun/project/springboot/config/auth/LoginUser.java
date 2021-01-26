package com.myeonghun.project.springboot.config.auth;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)// 어노 테이션이 생성 될수 있는 위치 지정
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // 이 파일을 어노테이션 파일로 지정
}
