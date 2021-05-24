package com.firstmonth.blog2.modules.posts.repository;

import com.firstmonth.blog2.modules.posts.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {


}