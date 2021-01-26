package com.myeonghun.project.springboot.config.auth.dto;

import com.myeonghun.project.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//인증된 사용자 정보만 implements Serializable 직렬화 문제로 session dto는 따로 만들어야 함

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
