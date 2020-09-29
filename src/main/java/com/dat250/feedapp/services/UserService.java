package com.dat250.feedapp.services;

import com.dat250.feedapp.models.User;
import com.dat250.feedapp.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> readAllUsers() {
        return userDAO.read();
    }

    public User readUserById(int id) {
        return userDAO.read(id);
    }

    public void createUser(User user) {
        userDAO.create(user);
    }

    public void deleteUser(int id) {
        userDAO.delete(id);
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

}
