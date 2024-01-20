package com.vicheanath.waa.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostDTO {
    private String title;
    private String content;
    private String author;
    private UserDTO user;
}
