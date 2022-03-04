package com.stimulus.web;

import com.stimulus.config.auth.dto.SessionUser;
import com.stimulus.service.posts.PostsService;
import com.stimulus.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){ //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있습니다.
        //여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달함
        model.addAttribute("posts", postsService.findAllDesc());
        // index.mustache에서 userName을 사용할 수 있게 model에 저장하는 코드 추가
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); // 1
        if (user != null){ // 2
            model.addAttribute("userName", user.getName());
        }
        /* 1. (SessionUser) httpSession.getAttribute("user") : 앞서 작성된 CustromOAuth2UserService에서
        *       로그인 성공 시 세션에 SessionUser를 저장하도록 구성했습니다.
        *       즉, 로그인 성공 시 httpSession.getAttribute("user")에서 값을 가져올 수 있습니다.
        * 2.  if (user != null){ : 세션에 저장된 값이 있을 때만 model에 userName으로 등록합니다.
        *       세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보이게 됩니다.*/
        return "index";
    }

    /* 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
    *  앞의 경로는 src/main/resources/templates로, 뒤의 확장자는 .mustache가 붙는다.
    *  해당 파일은 view resolver가 처리하게 된다. (view resolver는 url 요청의 결과를 전달할 타입과 값을 지정하는 관리자) */

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
