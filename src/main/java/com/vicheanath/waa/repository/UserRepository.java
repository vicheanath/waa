package com.vicheanath.waa.repository;

import com.vicheanath.waa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        User findById(Integer id);


        @Query("SELECT u FROM User u WHERE size(u.posts) > 1")
        public List<User> findMoreThanOnePost();


        @Query("SELECT u FROM User u WHERE size(u.posts) > ?1")
        public List<User> findMoreThanNPosts(Integer numPosts);


}
