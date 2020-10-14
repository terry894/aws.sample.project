package com.myeonghun.project.springboot.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

//ORM 자바 표준 ORM

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //pk의 생성 규칙을 나타냄
    //GenerationType.IDENTITY => auto_increment의 역할을 한다
    private Long id;//id 는 pk의 역할을 함

    @Column(length = 500, nullable = false)
    //column을 굳이 선언하지 않더라도 해당 클래스의 필드는 자동으로 칼럼으로 잡힌다.
    //기본값외에 추가적으로 필요한 옵션이 있을때 설정
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    //type을 text로 설정
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;

    }



}
