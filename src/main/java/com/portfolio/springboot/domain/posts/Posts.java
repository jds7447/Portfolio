package com.portfolio.springboot.domain.posts;

import com.portfolio.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/* JPA 기능 테스트용 도메인 Entity 클래스 (실제 DB와 매칭될 클래스이며 보통 Entity 클래스라고 부름) */
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

/*
@Entity
    테이블과 일크될 클래스임을 나타냄
    기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
    ex) SalesManager.java -->  sales_manager 테이블
*/
/*
@ID
    해당 테이블의 PK 필드를 나타냄
*/
/*
@GeneratedValue
    PK의 생성 규칙을 나타냄
    스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment 가 됨
*/
/*
@Column
    테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다
    사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶다거나(ex: title), 타입을 TEXT로 변경하고 싶다거나(ex:content) 등의 경우 사용
*/
/*
@NoArgsConstructor
    기본 생성자 자동 추가
    public Posts(){} 와 같은 효과
*/
/*
@Getter
    클래스 내 모든 필드의 Getter 메서드 자동 생성
*/
/*
@Builder
    해당 클래스의 빌더 패턴 클래스를 생성
    생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함

    예를 들어,
    public Example(String a, String b) {
        this.a = a;
        this.b = b;
    }
    일반 생성자의 경우 new Example(b, a) 의 형식으로 객체를 생성해도 문제점을 찾기 힘들다

    하지만 빌더 클래스를 이용한 생성자의 경우
    Example.builder()
        .a(a)
        .b(b)
        .build();
    의 형식으로 어느 필드에 어떤 값을 채워야 할지 명확하게 인지할 수 있다
*/