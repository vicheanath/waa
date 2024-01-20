package com.vicheanath.waa.service.impl;

import com.vicheanath.waa.dto.CommentsDTO;
import com.vicheanath.waa.dto.PostDTO;
import com.vicheanath.waa.entity.Comments;
import com.vicheanath.waa.entity.Post;
import com.vicheanath.waa.mapper.ListMapper;
import com.vicheanath.waa.repository.CommentsRepository;
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
    private final CommentsRepository commentsRepository;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;
    @Override
    public List<PostDTO> findAll(String containsTitle) {
        if (containsTitle == null) {
            return listMapper.mapList(postRepository.findAll(),PostDTO.class);
        }
        List<Post> posts = postRepository.findByTitleContaining(containsTitle);
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

    @Override
    public Optional<CommentsDTO> addComment(Integer id, CommentsDTO commentsDTO) {
        Optional<Post> postOptional = postRepository.findById(id);
        postOptional.ifPresent(post -> {
            Comments comments = modelMapper.map(commentsDTO,Comments.class);
            Comments comments1 = commentsRepository.save(comments);
            post.getComments().add(comments1);
            postRepository.save(post);
        });
        return Optional.of(commentsDTO);
    }
}
