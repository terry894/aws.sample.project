package com.myeonghun.project.springboot.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //auditing 기능 포함시킨다.
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    //entity를 변경 할 때 기록을 남기기 위해서 만든 추상 클래스

    @CreatedDate
    //entity가 생성되어 저장될 때 시간이 자동저장 된다.
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
