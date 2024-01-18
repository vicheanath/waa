package com.vicheanath.waa.controller;


import com.vicheanath.waa.dto.PostDTO;
import com.vicheanath.waa.entity.Post;
import com.vicheanath.waa.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PostDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Post post) {
        postService.save(post);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody PostDTO postDTO, @PathVariable Long id) {
        postService.update(id, postDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        postService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
