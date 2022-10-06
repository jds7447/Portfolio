package com.portfolio.springboot.web.dto;

import com.portfolio.springboot.domain.posts.Posts;
import lombok.Getter;

/* 조회한 Post 데이터 반환(응답) DTO (Dtos 영역) */
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}

/*
PostsResponseDto는 Entity의 필드 중 일부만 사용하므로
@Builder 어노테이션을 통해 굳이 모든 필드를 가진 생성자가 필요하지 않으므로
생성자 매개변수로 Entity를 받아 필드에 값을 넣는다
*/