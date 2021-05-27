package com.firstmonth.blog2.modules.posts.repository;

import com.firstmonth.blog2.modules.posts.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findByTitleContaining(String title);

    @Query("select p from Posts p where :#{#posts.title} is null or p.title like concat('%', :#{#posts.title}, '%')")
    List<Posts> findBySearch(Posts posts);

}
