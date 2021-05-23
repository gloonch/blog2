package com.firstmonth.blog2.modules.users.service;

import com.firstmonth.blog2.modules.users.model.Users;
import com.firstmonth.blog2.modules.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users register(Users users) {
        return usersRepository.save(users);
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
}
