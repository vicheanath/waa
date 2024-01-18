package com.vicheanath.waa.service.impl;

import com.vicheanath.waa.dto.PostDTO;
import com.vicheanath.waa.entity.Post;
import com.vicheanath.waa.repository.PostRepository;
import com.vicheanath.waa.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Override
    public List<PostDTO> findAll() {
        List<PostDTO> postDTOList = new ArrayList<>();
        List<Post> postList = postRepository.findAll();

        postList.forEach(post -> {
            PostDTO dto = new PostDTO();
            dto.setTitle(post.getTitle());
            dto.setContent(post.getContent());
            dto.setAuthor(post.getAuthor());
            postDTOList.add(dto);
        });
        return postDTOList;
    }

    @Override
    public PostDTO findById(Long id) {
        Post post = postRepository.findById(id);
        PostDTO dto = new PostDTO();
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setAuthor(post.getAuthor());
        return  dto;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void update(Long id,PostDTO postDTO) {
        Post post = postRepository.findById(id);
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setAuthor(postDTO.getAuthor());
        postRepository.update(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
