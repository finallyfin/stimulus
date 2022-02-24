package com.stimulus.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/* JpaRepository<Entity class, PK type> : 인터페이스 생성 후 JpaRepository 를 상속하면
*       기본적인 CRUD 메소드가 자동생성 된다. @Repository 필요없음. 단, Entity 클래스와
*       기본 Entity Repository는 함께 위치해야 한다. */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    /* 전체 조회 화면 만들기 */
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();


}
