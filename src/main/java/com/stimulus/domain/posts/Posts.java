package com.stimulus.domain.posts;

import com.stimulus.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //(lombok의 어노테이션)
@NoArgsConstructor //(lombok의 어노테이션) 기본 생성자 자동 추가
@Entity // 1 Entity (JPA의 어노테이션)
public class Posts extends BaseTimeEntity {

    @Id //2 Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //3 GeneratedValue
    private Long id;

    @Column(length = 500, nullable = false) // 4 Column
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    /* 1 Entity : 테이블과 링크될 클래스임을 나타냅니다.
    *       기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭합니다
    *       ex) SalesManager.java -> sales_manager table
    *  2 Id : 해당 테이블의 PK 필드를 나타냅니다.
    *  3 GeneratedValue : PK의 생성규칙을 나타냅니다.
    *       스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 가능
    * 4 Column : 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됩니다.
    *       사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용합니다.
    *       문자열의 경우 varchar(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나 타입을 TEXT로 변경
    *       하고 싶은 경우에 사용합니다.
    *  API를 만들기 위해 총 3개의 클래스가 필요하다.
    * 1. request 데이터를 받을 Dto
    * 2. API요청을 받을 Controller
    * 3. 트랜잭션, 도메인 기능 간의 순서를 보장하는 Service
    *
    * Web Layer : 흔히 사용하는 컨트롤러 등의 뷰 템플릿 영역
    *   (controllers, exception handlers, filters, view templates, etc)
    * Service Layer : @Service에 사용되는 서비스 영역. 일반적으로 Controller와 Dao 중간 영역에서 사용됨
    *                 @Transactional이 사용되어야 하는 영역
    * Repository Layer : database와 같이 데이터 저장소에 접근하는 영역
    * Dtos : 계층 간에 데이터 교환을 위한 객체들의 영역. 예를들어 뷰 템플릿 엔진에서 사용될 객체나 repository layer
    *       에서 결과로 넘겨준 객체 등이 이들을 이야기 한다.
    * Domain Model : 도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할 수 있도록
    *               단순화 시킨 것을 도메인 모델이라 한다.
    *               예로 택시 앱이라고 하면 배차, 탑승, 요금 등이 모두 도메인이 될 수 있다.
    *               @Entity가 사용된 영역 역시 도메인 모델.   */

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }



}
