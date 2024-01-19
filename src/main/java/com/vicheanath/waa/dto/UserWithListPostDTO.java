package com.vicheanath.waa.dto;

import com.vicheanath.waa.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserWithListPostDTO {
    private Integer id;
    private String name;
    private List<Post> posts;
}
