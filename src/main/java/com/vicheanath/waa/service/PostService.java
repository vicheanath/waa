package com.vicheanath.waa.service;

import com.vicheanath.waa.dto.CommentsDTO;
import com.vicheanath.waa.dto.PostDTO;
import com.vicheanath.waa.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<PostDTO> findAll(String containsTitle);

    Optional<PostDTO> findById(Integer id);

    Optional<PostDTO> save(PostDTO post);

    Optional<PostDTO> update(Integer id, PostDTO postDTO);

    void deleteById(Integer id);

    Optional<CommentsDTO> addComment(Integer id, CommentsDTO commentsDTO);
}
