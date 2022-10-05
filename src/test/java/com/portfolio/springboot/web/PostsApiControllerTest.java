package com.portfolio.springboot.web;

import com.portfolio.springboot.domain.posts.Posts;
import com.portfolio.springboot.domain.posts.PostsRepository;
import com.portfolio.springboot.web.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception {
        //given
        String title = "title";
        String content = "content";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

}

/*
@WebMvcTest 를 사용하지 않은 이유
    @WebMvcTest의 경우 JPA 기능이 작동하지 않음
    Controller와 ControllerAdvice 등 외부 연동과 관련된 부분만 활성화 됨

    JPA 기능까지 한 번에 테스트할 때는 @SpringBootTest 와 TestRestTemplate 를 사용
*/
/*
WebEnvironment.RANDOM_PORT
    랜덤 포트 실행
*/
/*
@LocalServerPort
    현재 서버의 포트 번호 주입
*/