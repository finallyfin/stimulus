package com.stimulus.web;

import com.stimulus.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){ //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있습니다.
        //여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달함
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    /* 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
    *  앞의 경로는 src/main/resources/templates로, 뒤의 확장자는 .mustache가 붙는다.
    *  해당 파일은 view resolver가 처리하게 된다. (view resolver는 url 요청의 결과를 전달할 타입과 값을 지정하는 관리자) */

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

}
