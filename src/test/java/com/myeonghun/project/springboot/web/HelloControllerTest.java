package com.myeonghun.project.springboot.web;
import com.myeonghun.project.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";


        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void HelloDto가_리턴된다() throws Exception{
        String name1 = "hello1";
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //json애서 받아오는것 $.name 을 is(name)과 비교
                .andExpect(jsonPath("$.amount", is(amount)));



    }

}
