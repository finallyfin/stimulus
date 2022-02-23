package com.stimulus.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/* JpaRepository<Entity class, PK type> : 인터페이스 생성 후 JpaRepository 를 상속하면
*       기본적인 CRUD 메소드가 자동생성 된다. @Repository 필요없음. 단, Entity 클래스와
*       기본 Entity Repository는 함께 위치해야 한다. */
public interface PostsRepository extends JpaRepository<Posts, Long> {


}
