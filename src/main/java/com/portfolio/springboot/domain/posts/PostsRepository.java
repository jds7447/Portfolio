package com.portfolio.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/* Posts 클래스로 Database를 접근하기 위한 JpaRepository 인터페이스 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}

/*
보통 ibatis나 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자이다
JPA에선 Repository라고 부르며 인터페이스로 생성
단순히 인터페이스 생성 후 JpaRepository<Entity 클래스, PK 타입> 를 상속하면 기본적인 CRUD 메서드가 자동으로 생성
@Repository 를 추가할 필요도 없음
Entity 클래스와 기본 Entity Repository는 함께 위치해야 함 (둘은 아주 밀접하고, Entity 클래스는 기본 Repository 없이 제역할을 할 수 없음)
*/