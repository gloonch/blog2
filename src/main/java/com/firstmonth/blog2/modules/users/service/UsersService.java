package com.firstmonth.blog2.modules.users.service;

import com.firstmonth.blog2.modules.users.model.Users;
import com.firstmonth.blog2.modules.users.repository.UsersRepository;
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
public class UsersService {

    UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users register(Users users) throws IOException {
//        getting image name
        String path = ResourceUtils.getFile("classpath:static/images/").getPath();
        byte[] bytes = users.getFile().getBytes();
//        writes the particular data with a compatible system file separator by the OS
        Files.write(Paths.get(path + File.separator + users.getFile().getOriginalFilename()), bytes);
        users.setCover(users.getFile().getOriginalFilename());
        return usersRepository.save(users);
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
}
