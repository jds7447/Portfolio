package com.portfolio.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

/* Posts 도메인의 테스트 코드 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                                    .title(title)
                                    .content(content)
                                    .author("jds7447@naver.com")
                                    .build()
                            );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}

/*
@After
    Junit에서 단위 테스트가 끝날 때마다 수행되는 메서드 지정
    보통은 배포 전 전체 테스트를 수행할 때 테스트 간 데이터 침범을 막기 위해 사용한다
    여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아 있어 다음 테스트 실행 시 테스트가 실패할 수 있음
*/
/*
postRepository.save
    테이블 posts에 insert/update 쿼리를 실행
    id 값이 있다면 update가, 없다면 insert 쿼리가 실행됨
*/
/*
postsRepository.findAll
    테이블 posts에 있는 모든 데이터를 조회해 오는 메서드
*/
/*
@SpringBootTest
    별다른 설정 없이 해당 어노테이션을 사용할 경우 H2 데이터베이스를 자동으로 실행
*/