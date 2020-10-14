package com.myeonghun.project.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}

//선언된 모든 필드의 get매소드 생성
//선언된 모든 필드에 final필드가 포함된 생성자를 생성한다
//final이 없는 필드는 생성자에 포함되지 않는다.
