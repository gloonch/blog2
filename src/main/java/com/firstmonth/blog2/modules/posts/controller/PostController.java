package com.firstmonth.blog2.modules.posts.controller;

import com.firstmonth.blog2.modules.posts.model.Posts;
import com.firstmonth.blog2.modules.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostsService postsService;

    @Autowired
    public PostController(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody
    Posts registerPostimg(@ModelAttribute Posts posts) throws IOException {
        return postsService.register(posts);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<Posts> getAllPosts() {
        return postsService.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    Posts registerPost(Posts posts) throws IOException {
        return postsService.register(posts);
    }
}
