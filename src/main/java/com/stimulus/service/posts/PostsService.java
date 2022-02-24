package com.stimulus.service.posts;

import com.stimulus.domain.posts.Posts;
import com.stimulus.domain.posts.PostsRepository;
import com.stimulus.web.dto.PostsListResponseDto;
import com.stimulus.web.dto.PostsResponseDto;
import com.stimulus.web.dto.PostsSaveRequestDto;
import com.stimulus.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    /* postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto 변환 -> List로 반환하는 메소드 입니다. */
    @Transactional(readOnly = true) //(readOnly = true) : 트랜잭션 범위는 유지하되, 조회기능만 남겨서 조회 속도 높아짐
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) // <- 코드는 이것과 동일하다. .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }
}
