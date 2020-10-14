package com.myeonghun.project.springboot.web.dto;

import com.myeonghun.project.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String content;
    private String title;
    private String author;

    public PostsResponseDto(Posts Entity){
        this.id = Entity.getId();
        this.content = Entity.getContent();
        this.title = Entity.getTitle();
        this.author = Entity.getAuthor();
    }
}
