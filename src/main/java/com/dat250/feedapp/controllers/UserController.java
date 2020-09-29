package com.dat250.feedapp.controllers;

import com.dat250.feedapp.models.User;
import com.dat250.feedapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    List<User> getUsers() {
        return userService.readAllUsers();
    }

    @GetMapping("/user/{id}")
    User getUser(@PathVariable(name = "id") int id) {
        return userService.readUserById(id);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable(name = "id") int id) {
        userService.deleteUser(id);
    }
}
