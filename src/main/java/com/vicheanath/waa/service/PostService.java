package com.vicheanath.waa.service;

import com.vicheanath.waa.dto.PostDTO;
import com.vicheanath.waa.entity.Post;

import java.util.List;

public interface PostService {

    List<PostDTO> findAll();

    PostDTO findById(Long id);

    void save(Post post);

    void update(Long id, PostDTO postDTO);

    void deleteById(Long id);
}
