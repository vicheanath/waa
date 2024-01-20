package com.vicheanath.waa.controller;

import com.vicheanath.waa.dto.CommentsDTO;
import com.vicheanath.waa.dto.PostDTO;
import com.vicheanath.waa.dto.UserDTO;
import com.vicheanath.waa.dto.UserWithListPostDTO;
import com.vicheanath.waa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserWithListPostDTO>> findAll(@RequestParam(value = "numPosts",required = false) Integer numPosts) {
        return ResponseEntity.ok(userService.findAll(numPosts));
    }

    @GetMapping("/findMoreThanOnePost")
    public ResponseEntity<List<UserDTO>> findMoreThanOnePost() {
        return ResponseEntity.ok(userService.findMoreThanOnePost());
    }
    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user) {
        Optional<UserDTO> userDTO = userService.save(user);
        return userDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<UserWithListPostDTO> findPostsByUserId(@PathVariable("id") Integer id) {
        System.out.println("id = " + id);
        return ResponseEntity.ok(userService.findUserByIdWithPosts(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable Integer id) {
        Optional<UserDTO> user = userService.update(id, userDTO);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Objects> deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();

    }




}
