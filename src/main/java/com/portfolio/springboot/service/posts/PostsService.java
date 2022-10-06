package com.portfolio.springboot.service.posts;

import com.portfolio.springboot.domain.posts.Posts;
import com.portfolio.springboot.domain.posts.PostsRepository;
import com.portfolio.springboot.web.dto.PostsResponseDto;
import com.portfolio.springboot.web.dto.PostsSaveRequestDto;
import com.portfolio.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/* Post 관련 서비스 (서비스 영역) */
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    /* post 데이터 등록 => C REATE / REST - POST / DB - INSERT */
    //전달 받은 post 저장 DTO 객체의 toEntity() 메서드로 Posts 엔티티(도메인) 객체 생성 후 DAO 객체로 DB 에 저장 및 해당 데이터의 ID 가져오기
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        //postsRepository.save(Entity) : Entity 데이터를 DB에 저장 후 저장된 Entity 객체를 반환
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    /* post 데이터 수정 => U PDATE / REST - PUT / DB - UPDATE */
    //전달 받은 id 값으로 DB에서 해당 id에 해당하는 데이터를 찾아 Posts 엔티티 객체로 가져온다
    //가져온 Posts 엔티티의 데이터를 전달 받은 post 수정 DTO 객체의 데이터로 수정한다 (제목과 내용만)
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        //postsRepository.findById(id) : id에 해당하는 데이터를 DB에서 찾아 해당 Entity 객체를 반환
        //.orElseThrow(Exception) : 전달 받은 id에 해당하는 데이터가 없을 경우 예외 처리
        //() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id) : 람다식을 이용해 지정된 메시지를 출력하는 예외 생성
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    /*
    위 update 메서드에서 데이터베이스에 쿼리를 날리는 부분이 없는 이유
        JPA의 영속성 컨텍스트 때문
    */

    /* post 데이터 조회 => R EAD / REST - GET / DB - SELECT */
    //전달 받은 id 값으로 DB에서 해당 id에 해당하는 데이터를 찾아 Posts 엔티티 객체로 가져온다
    @Transactional
    public PostsResponseDto findById(Long id) {
        //postsRepository.findById(id) : id에 해당하는 데이터를 DB에서 찾아 해당 Entity 객체를 반환
        //.orElseThrow(Exception) : 전달 받은 id에 해당하는 데이터가 없을 경우 예외 처리
        //() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id) : 람다식을 이용해 지정된 메시지를 출력하는 예외 생성
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

}
