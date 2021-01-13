package com.myeonghun.project.springboot.service.posts;

import com.myeonghun.project.springboot.domain.posts.Posts;
import com.myeonghun.project.springboot.domain.posts.PostsRepository;
import com.myeonghun.project.springboot.web.dto.PostsListResponseDto;
import com.myeonghun.project.springboot.web.dto.PostsResponseDto;
import com.myeonghun.project.springboot.web.dto.PostsSaveRequestDto;
import com.myeonghun.project.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
//트랜젝션, 도메인의 순서만 지정해 준다.
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public void delete (Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }

    @Transactional
    public Long save (PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update (Long id , PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional(readOnly=true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) // posts -> new PostsListResponseDto(posts)
                .collect(Collectors.toList());
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다. id ="+ id));

        return new PostsResponseDto(entity);
    }
}
