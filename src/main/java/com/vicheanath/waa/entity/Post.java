package com.vicheanath.waa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String author;
    @ManyToOne()
    @JsonBackReference
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "post_id")
    @BatchSize(size = 5)
    private List<Comments> comments;
}
