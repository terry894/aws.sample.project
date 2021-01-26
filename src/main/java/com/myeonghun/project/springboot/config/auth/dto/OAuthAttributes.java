package com.myeonghun.project.springboot.config.auth.dto;

import com.myeonghun.project.springboot.domain.user.Role;
import com.myeonghun.project.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;


import java.nio.file.FileStore;
import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String , Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    //OAuth2User에서 반환하는 사용자정보는 Map이기 때문에 값 하나하나를 반환 해야함
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();

    }

    //USer엔티티 생성
    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)//기본권한
                .build();
    }



}
