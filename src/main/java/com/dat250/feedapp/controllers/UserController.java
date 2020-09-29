package com.dat250.feedapp.controllers;

import com.dat250.feedapp.models.User;
import com.dat250.feedapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user")
    User userPoll(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable(name = "id") int id) {
        userService.deleteUser(id);
    }

    @PutMapping("/user")
    User putUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }
}
