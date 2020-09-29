package com.dat250.feedapp.services;

import java.util.List;

import com.dat250.feedapp.models.User;
import com.dat250.feedapp.repositories.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserDAO userDAO;

  public List<User> getAllUsers() {
    return userDAO.read();
  }

  public User getUserById(int id) {
    return userDAO.read(id);
  }
}
