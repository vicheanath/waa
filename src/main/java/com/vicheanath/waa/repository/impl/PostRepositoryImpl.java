package com.vicheanath.waa.repository.impl;

import com.vicheanath.waa.entity.Post;
import com.vicheanath.waa.repository.PostRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private static List<Post> posts;

    static {
            posts = new ArrayList<>();
            posts.add(new Post(1L, "Post 1", "Content of Post 1", "Author 1"));
            posts.add(new Post(2L, "Post 2", "Content of Post 2", "Author 2"));
            posts.add(new Post(3L, "Post 3", "Content of Post 3", "Author 3"));
            posts.add(new Post(4L, "Post 4", "Content of Post 4", "Author 4"));
            posts.add(new Post(5L, "Post 5", "Content of Post 5", "Author 5"));
        }




    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(Long id) {
        return posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Post post) {
        posts.add(post);
    }

    @Override
    public void deleteById(Long id) {
        posts.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public void update(Post post) {
        posts.stream().filter(p -> p.getId().equals(post.getId())).forEach(p -> {
            p.setTitle(post.getTitle());
            p.setContent(post.getContent());
            p.setAuthor(post.getAuthor());
        });
    }
}
