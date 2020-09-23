package com.dat250.feedapp.controllers;

import java.util.List;

import com.dat250.feedapp.models.User;
import com.dat250.feedapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  List<User> getUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/user/{id}")
  User getUser(@PathVariable(name = "id") int id) {
    return userService.getUserById(id);
  }
}
