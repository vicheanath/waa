package com.vicheanath.waa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PostWithCommentsDTO extends PostDTO{
    private List<CommentsDTO> comments;
}
