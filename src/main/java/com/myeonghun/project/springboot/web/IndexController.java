package com.myeonghun.project.springboot.web;

import com.myeonghun.project.springboot.service.posts.PostsService;
import com.myeonghun.project.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
    }

//    @GetMapping("posts/delete/{{id}}")
//    public String DeletePosts(@PathVariable Long id, Model model){
//        ;
//    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id ,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

    @GetMapping("/posts/save")
    public String postsSave(){ return "posts-save"; }

}
