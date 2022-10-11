package com.portfolio.springboot.web;

import com.portfolio.springboot.service.posts.PostsService;
import com.portfolio.springboot.web.dto.PostsResponseDto;
import com.portfolio.springboot.web.dto.PostsSaveRequestDto;
import com.portfolio.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/* Post 관련 REST API 컨트롤러 (웹 영역) */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    /* post 데이터 등록 => C REATE / REST - POST / DB - INSERT */
    //전달 받은 post 저장 DTO 객체를 인수로 서비스 객체의 save 메서드 호출 후 결과 값 반환
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    /* post 데이터 수정 => U PDATE / REST - PUT / DB - UPDATE */
    //전달 받은 id와 post 수정 DTO 객체를 인수로 서비스 객체의 update 메서드 호출 후 결과 값 반환
    @PutMapping("api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    /* post 데이터 조회 => R EAD / REST - GET / DB - SELECT */
    //전달 받은 id 값으로 해당 id를 기본키로 등록된 post 데이터를 조회하여 반환
    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
