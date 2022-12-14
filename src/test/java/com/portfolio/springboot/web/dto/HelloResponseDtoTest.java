package com.portfolio.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/* Lombok 테스트의 테스트 코드 */
public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

/*
assertThat
    assertj라는 테스트 검증 라이브러리의 검증 메서드
    검증하고 싶은 대상을 메서드 인자로 받는다
    메서드 체이닝이 지원되어 isEqualTo와 같이 메서드를 이어서 사용 가능
*/
/*
isEqualTo
    assertj의 동등 비교 메서드
    assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공
*/

/*
Junit의 기본 assertThat이 아닌 assertj의 assertThat을 사용
assertj 역시 Junit에서 자동으로 라이브러리 등록을 해줌

Junit 과 비교하여 assertj의 장점
    CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않다
        - Junit의 assertThat 을 쓰게 되면 is() 와 같이 CoreMatchers 라이브러리가 필요
    자동완성이 좀 더 확실하게 지원됨
        - IDE 에서는 CoreMatchers와 같은 Matcher 라이브러리의 자동완성 지원이 약함
*/