package com.myeonghun.project.springboot.domain.user;

<<<<<<< HEAD

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity{
=======
import com.myeonghun.project.springboot.domain.BaseTimeEntity;
import lombok.Builder;

import javax.persistence.*;

public class User extends BaseTimeEntity {
>>>>>>> 442d8a7e1e1a33d3e70915b2128aa9901b862d7a

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
<<<<<<< HEAD
        this.role = role;
    }

    public User update(String name, String picture){
=======
        this.role= role;
    }

    public User Update(String name , String picture){

>>>>>>> 442d8a7e1e1a33d3e70915b2128aa9901b862d7a
        this.name = name;
        this.picture = picture;

        return this;
    }

<<<<<<< HEAD
    public String getRoleKey() {
        return this.role.getKey();
    }




=======
    public String getRoleKey(){
        return this.role.getRoleKey();
    }


>>>>>>> 442d8a7e1e1a33d3e70915b2128aa9901b862d7a
}
