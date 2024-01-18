package com.vicheanath.waa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String content;
    private String author;

    public Post() {

    }
}
