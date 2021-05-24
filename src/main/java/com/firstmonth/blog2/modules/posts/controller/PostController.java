package com.firstmonth.blog2.modules.posts.controller;

import com.firstmonth.blog2.modules.posts.model.Posts;
import com.firstmonth.blog2.modules.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostsService postsService;

    @Autowired
    public PostController(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Posts> getAllPosts() {
        return postsService.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Posts registerPost(Posts posts) {
        return postsService.register(posts);
    }
}
