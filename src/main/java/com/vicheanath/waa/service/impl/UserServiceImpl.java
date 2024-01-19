package com.vicheanath.waa.service.impl;

import com.vicheanath.waa.dto.PostDTO;
import com.vicheanath.waa.dto.UserDTO;
import com.vicheanath.waa.dto.UserWithListPostDTO;
import com.vicheanath.waa.entity.User;
import com.vicheanath.waa.mapper.ListMapper;
import com.vicheanath.waa.repository.UserRepository;
import com.vicheanath.waa.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final ListMapper listMapper;
    public List<UserDTO> findAll() {
        return listMapper.mapList(userRepository.findAll(),UserDTO.class);
    }
    @Override
    public UserDTO findById(Integer id) {
        return modelMapper.map(userRepository.findById(id),UserDTO.class);
    }

    @Override
    public Optional<UserDTO> save(UserDTO user) {
        User user1 = modelMapper.map(user,User.class);
        return Optional.of(modelMapper.map(userRepository.save(user1),UserDTO.class));
    }

    @Override
    public Optional<UserDTO> update(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id);
        user.setName(userDTO.getName());
        return Optional.of(modelMapper.map(userRepository.save(user),UserDTO.class));
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.delete(userRepository.findById(id));
    }

    @Override
    public UserWithListPostDTO findUserByIdWithPosts(Integer id) {
        User user = userRepository.findById(id);
        UserWithListPostDTO userWithListPostDTO = new UserWithListPostDTO();
        userWithListPostDTO.setId(user.getId());
        userWithListPostDTO.setName(user.getName());
        userWithListPostDTO.setPosts(listMapper.mapList(user.getPosts(), PostDTO.class));
        return userWithListPostDTO;

    }

    @Override
    public List<UserDTO> findMoreThanOnePost() {
        List<User> users = userRepository.findMoreThanOnePost();
        return listMapper.mapList(users,UserDTO.class);
    }
}
