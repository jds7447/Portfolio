package com.portfolio.springboot.web.dto;

import com.portfolio.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/* Post 요청 데이터 저장 관련 DTO (Dtos 영역) */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}

/*
Entity 클래스인 Posts.java와 유사한 DTO 클래스를 별도로 생성한 이유
    절대 Entity 클래스를 Request/Response 클래스로 사용해서는 안됨
    Entity 클래스는 테이터베이스와 맞닿은 핵심 클래스
    Entity 클래스를 기준으로 테이블 생성, 스키마 변경 등이 수행됨
    수많은 서비스 클래스와 비즈니스 로직들이 Entity 클래스를 기준으로 동작함
    Entity 클래스가 변경되면 여러 클래스에 영향을 끼침
    
    Request와 Response용 DTO는 View를 위한 클래스라 자주 변경이 필요
    실제로 Controller에서 결과값으로 여러 테이블을 조인해서 줘야 할 경우가 빈번하여 Entity 클래스만으로 표현하기 어려움
    
    반드시 Entity 클래스와 Conroller에서 쓸 DTO는 분리해서 사용하는 것이 좋음
    View Layer와 DB Layer의 역할 분리를 철저히 해야함
*/