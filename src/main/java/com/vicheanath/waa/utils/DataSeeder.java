package com.vicheanath.waa.utils;

import com.vicheanath.waa.entity.Comments;
import com.vicheanath.waa.entity.Post;
import com.vicheanath.waa.entity.Role;
import com.vicheanath.waa.entity.User;
import com.vicheanath.waa.repository.CommentsRepository;
import com.vicheanath.waa.repository.PostRepository;
import com.vicheanath.waa.repository.RolesRepository;
import com.vicheanath.waa.repository.UserRepository;
import com.vicheanath.waa.service.PostService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private  final RolesRepository rolesRepository;
    private  final UserRepository userRepository;
    private  final PostRepository postRepository;
    private  final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataSeeder.run - START");
        createRole();
        createUser();
        createPost();
        addComment();
        System.out.println("DataSeeder.run - END");
    }

    public  void createRole() {
        String[] roles = {"ADMIN", "CLIENT", "USER"};
        for (String role : roles) {
                    if (!rolesRepository.existsByName(role)) {
                        Role roles1 = new Role();
                        roles1.setName(role);
                        rolesRepository.save(roles1);
                    }
                }
            }

    public  void createUser() {
        Role admin = rolesRepository.findByName("ADMIN");
        Role client = rolesRepository.findByName("CLIENT");
        User user = new User();
        user.setName("Viche Nath");
        user.setEmail("vnath@miu.edu");
        user.setPassword("123456");
        user.setRoles(List.of(admin, client));


        User user1 = new User();
        user1.setName("abc");
        user1.setEmail("abc@miu.edu");
        user1.setPassword("123456");
        user1.setRoles(List.of(client));

        User client1 = new User();
        client1.setName("client1");
        client1.setEmail("client@miu.edu");
        client1.setPassword("123456");
        client1.setRoles(List.of(client));

        User admin1 = new User();
        admin1.setName("admin1");
        admin1.setEmail("admin1@miu.edu");
        admin1.setPassword("123456");
        admin1.setRoles(List.of(admin));

        List<User> users = List.of(user, user1, client1, admin1);
        for(User u: users) {
            u.setPassword(passwordEncoder.encode(u.getPassword()));
            userRepository.save(u);
        }


    }

    public  void createPost() {
        Post post1 = new Post();
        post1.setTitle("Post 1");
        post1.setContent("Post 1 content");
        post1.setAuthor("David");
        post1.setUser(userRepository.findByEmail("admin1@miu.edu"));

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setContent("Post 2 content");
        post2.setAuthor("HOlly");
        post2.setUser(userRepository.findByEmail("client@miu.edu"));

        Post post3 = new Post();
        post3.setTitle("Post 3");
        post3.setContent("Post 3 content");
        post3.setAuthor("Helen");
        post3.setUser(userRepository.findByEmail("admin1@miu.edu"));

        Post post4 = new Post();
        post4.setTitle("Post 4");
        post4.setContent("Post 4 content");
        post4.setAuthor("Helen");
        post4.setUser(userRepository.findByEmail("admin1@miu.edu"));

        List<Post> posts = List.of(post1, post2, post3, post4);
        postRepository.saveAll(posts);
    }

    public  void addComment() {

    }

}
