package com.firstmonth.blog2.modules.posts.service;

import com.firstmonth.blog2.modules.posts.model.Posts;
import com.firstmonth.blog2.modules.posts.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PostsService {

    PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Posts register(Posts posts) throws IOException {
//        getting image name
        String path = ResourceUtils.getFile("classpath:static/images/").getPath();
        byte[] bytes = posts.getFile().getBytes();
//        write: saving this file in the particular given path
//        file separator: picks a compatible system separator depend on your OS
        Files.write(Paths.get(path + File.separator + posts.getFile().getOriginalFilename()), bytes);
        posts.setCover(posts.getFile().getOriginalFilename());
        return postsRepository.save(posts);
    }

    public List<Posts> findAll() {
        return postsRepository.findAll();
    }

    public List<Posts> findBySearch(Posts posts) {
        return postsRepository.findByTitleContaining(posts.getTitle());
    }
}
