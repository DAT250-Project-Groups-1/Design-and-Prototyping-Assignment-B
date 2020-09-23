package com.dat250.feedapp.services;

import java.util.List;

import com.dat250.feedapp.models.User;
import com.dat250.feedapp.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(int id) {
    return userRepository.getOne(id);
  }
}
