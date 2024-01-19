package com.vicheanath.waa.service.impl;

import com.vicheanath.waa.dto.PostDTO;
import com.vicheanath.waa.entity.Post;
import com.vicheanath.waa.mapper.ListMapper;
import com.vicheanath.waa.repository.PostRepository;
import com.vicheanath.waa.service.PostService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;
    @Override
    public List<PostDTO> findAll() {
        List<Post> posts = postRepository.findAll();
        return listMapper.mapList(posts,PostDTO.class);
    }

    @Override
    public Optional<PostDTO> findById(Integer id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found  with id " + id + " !"));
        return Optional.of(modelMapper.map(post,PostDTO.class));
    }

    @Override
    public  Optional<PostDTO> save(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO,Post.class);
        PostDTO postDTO1 = modelMapper.map(postRepository.save(post),PostDTO.class);
        return Optional.of(postDTO1);
    }

    @Override
    public  Optional<PostDTO> update(Integer id,PostDTO postDTO) {
        Optional<Post> postOptional = postRepository.findById(id);
        postOptional.ifPresent(post -> postRepository.save(modelMapper.map(postDTO,Post.class)));
        return Optional.of(modelMapper.map(postOptional,PostDTO.class));
    }

    @Override
    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }
}
