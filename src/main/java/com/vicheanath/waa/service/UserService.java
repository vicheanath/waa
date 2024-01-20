package com.vicheanath.waa.service;


import com.vicheanath.waa.dto.CommentsDTO;
import com.vicheanath.waa.dto.PostDTO;
import com.vicheanath.waa.dto.UserDTO;
import com.vicheanath.waa.dto.UserWithListPostDTO;
import com.vicheanath.waa.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserWithListPostDTO> findAll(Integer numPosts);
    UserDTO findById(Integer id);

    Optional<UserDTO> save(UserDTO user);

    Optional<UserDTO> update(Integer id, UserDTO user);

    void deleteById(Integer id);

    UserWithListPostDTO findUserByIdWithPosts(Integer id);


    List<UserDTO> findMoreThanOnePost();

}
