package com.firstmonth.blog2.modules.users.controller;

import com.firstmonth.blog2.modules.users.model.Users;
import com.firstmonth.blog2.modules.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Users> getAllUsers() {
        return usersService.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Users registerUser(Users users) {
        return usersService.register(users);
    }

}