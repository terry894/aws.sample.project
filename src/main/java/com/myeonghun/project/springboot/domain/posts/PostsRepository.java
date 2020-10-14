package com.myeonghun.project.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//인터페이스 생성 후 JpaRepository를 상속하면 기본적인 CRUD생성
//Entity와 Repository는 항상 함께위치 해야한다.
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
