package com.portfolio.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
모든 Entity의 상의 클래스가 되어
Entity들의 createdDate, modifiedDate를 자동 관리하는 역할
즉, Entity(테이블)에 데이터가 생성(insert), 수정(update) 될 때 생성 날짜(0000/00/00 00:00:00), 수정 날짜을 추가할 때 사용된다
*/
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    
    @CreatedDate
    private LocalDateTime createdDate;
    
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}

/*
@MappedSuperclass
    JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 한다
*/
/*
@EntityListeners(AuditingEntityListener.class)
    BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다 (예를 들어 이 클래스를 상속 받은 도메인(Entity 클래스)을 영속성 컨텍스트에 저장하거나 update를 하는 경우를 감시한다)
*/
/*
@CreatedDate
    Entity가 생성되어 저장될 때 시간이 자동 저장됨
*/
/*
@LastModifiedDate
    조회한 Entity의 값을 변경할 때 시간이 자동 저장됨
*/