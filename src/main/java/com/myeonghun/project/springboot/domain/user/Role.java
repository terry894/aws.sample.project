package com.myeonghun.project.springboot.domain.user;

import lombok.Getter;
<<<<<<< HEAD
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum  Role {
     GUEST("ROLE_GUEST", "손님"),
     USER("ROLE_USER", "일반사용자");

     private final String Key;
     private final String title;
=======
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role{
>>>>>>> 442d8a7e1e1a33d3e70915b2128aa9901b862d7a
}
