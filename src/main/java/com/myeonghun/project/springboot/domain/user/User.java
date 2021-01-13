package com.myeonghun.project.springboot.domain.user;

import com.myeonghun.project.springboot.domain.BaseTimeEntity;
import lombok.Builder;

import javax.persistence.*;

public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role= role;
    }

    public User Update(String name , String picture){

        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getRoleKey();
    }


}
