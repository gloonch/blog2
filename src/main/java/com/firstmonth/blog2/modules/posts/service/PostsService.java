package com.firstmonth.blog2.modules.posts.service;

import com.firstmonth.blog2.modules.posts.model.Posts;
import com.firstmonth.blog2.modules.posts.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Posts register(Posts posts) {
        return postsRepository.save(posts);
    }

    public List<Posts> findAll() {
        return postsRepository.findAll();
    }
}
