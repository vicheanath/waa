package com.vicheanath.waa.controller;


import com.vicheanath.waa.dto.PostDTO;
import com.vicheanath.waa.entity.Post;
import com.vicheanath.waa.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }



    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable Integer id) {
        Optional<PostDTO> postDTO = postService.findById(id);
        return postDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PostDTO> save(@RequestBody PostDTO post) {
        Optional<PostDTO> postDTO = postService.save(post);
        return postDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> update(@RequestBody PostDTO postDTO, @PathVariable Integer id) {
        Optional<PostDTO> post = postService.update(id, postDTO);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Objects> deleteById(@PathVariable Integer id) {
        postService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
