package com.myeonghun.project.springboot.web;

import com.myeonghun.project.springboot.config.auth.LoginUser;
import com.myeonghun.project.springboot.config.auth.dto.SessionUser;
import com.myeonghun.project.springboot.service.posts.PostsService;
import com.myeonghun.project.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());

        //로그인 성공시 세션에 SessionUser를 저장 하도록 구성
        //SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }

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
