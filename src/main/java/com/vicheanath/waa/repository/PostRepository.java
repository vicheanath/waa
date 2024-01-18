package com.vicheanath.waa.repository;

import com.vicheanath.waa.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository {
    List<Post> findAll();
    Post findById(Long id);
    void save(Post post);

    void deleteById(Long id);

    void update(Post post);

}
