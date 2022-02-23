package com.stimulus.web.dto;

import com.stimulus.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
    /* 해당 Dto 클래스는 Entity 클래스와 유사하지만 만들어주었다. 왜냐하면 Entity 클래스를
    * Request/Response 클래스로 사용해서는 안되기 때문이다.  */



}
