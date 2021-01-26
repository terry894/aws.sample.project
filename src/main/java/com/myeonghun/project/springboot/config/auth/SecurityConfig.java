package com.myeonghun.project.springboot.config.auth;

import com.myeonghun.project.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //springSecurity 설정을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService; // final 클래스 앝에 붙으면 상속 안됨

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옴션들을 disable
        .and()
                .authorizeRequests()//URL별 권한 관리 설정하는 옵션의 시작점 authorizeRequests이후에 antMatchers 쓸 수 있음
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()//권한 관리 대상을 지정하는 옵션
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // "/api/v1/**" 주소를 가진 API는 USER권환을 가진 사람만 가능
                .anyRequest().authenticated() // 설정된 값들 이외 나머지 URL들을 나타낸다 authenticated 인증된 사용자들만 가능 (로그인된 사용자)
        .and()
                .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()//Oauth2 로그인 기능에 대한 여러 설정 진입점
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);



    }
}
