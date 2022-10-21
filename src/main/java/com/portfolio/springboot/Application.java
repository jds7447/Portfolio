package com.portfolio.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/* 앞으로 만들 프로젝트의 메인 클래스 */
@EnableJpaAuditing   //JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
@SpringBootApplication
@SpringBootApplication 으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정된다
특히 @SpringBootApplication 이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트 최상단에 위치해야 한다
*/
/*
SpringApplication.run(Application.class, args)
main 메서드에서 실행하는 SpringApplication.run 으로 인해 내장 WAS(Web Application Server)를 실행
내장 WAS는 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행
내장 WAS로 인해 서버에 톰캣(TomCat == WAS)을 설치할 필요가 없게 되고, 스프링 부트로 만들어진 Jar(실행 가능한 Java 패키징 파일) 파일로 실행 가능
스프링 부트에서만 내장 WAS를 사용할 수 있는 것은 아니지만 스프링 부트에서는 내장 WAS 사용을 권장한다
내장 WAS를 사용하면 "언제 어디서나 같은 환경에서 스프링 부트를 배포" 할 수 있기 때문이다

외장 WAS를 쓴다고 하면 모든 서버는 WAS의 종류와 버전, 설정을 일치시켜야 하기 때문에 변경, 확장에 불리하다
*/