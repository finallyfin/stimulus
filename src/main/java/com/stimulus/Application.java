package com.stimulus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaAuditing //JPA Auditing 활성화
// HelloControllerTest돌리고 있는데 JPA metamodel must not be empty! 이런 에러가 나서,
// 원인을 찾아보니 @EnableJpaAuditing랑 @SpringBootApplication랑 함께 있다보니 @WebMvcTest에서도 스캔하게 됨.
// 따라서 분리시킴. @EnableJpaAuditing를 여기서 삭제하고 config패키지에 JpaConfig를 생성하여 다시 살려낼거임.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
