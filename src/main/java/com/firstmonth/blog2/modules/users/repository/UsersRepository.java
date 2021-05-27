package com.firstmonth.blog2.modules.users.repository;

import com.firstmonth.blog2.modules.posts.model.Posts;
import com.firstmonth.blog2.modules.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);

}
