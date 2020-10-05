package com.dat250.feedapp.services;

import com.dat250.feedapp.models.Poll;
import com.dat250.feedapp.models.User;
import com.dat250.feedapp.repositories.PollDAO;
import com.dat250.feedapp.repositories.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {
    @Autowired
    private PollDAO pollDAO;

    @Autowired
    private UserDAO userDAO;

    public List<Poll> readAllPolls() {
        return pollDAO.read();
    }

    public Poll readPoll(int id) {
        return pollDAO.read(id);
    }

    public boolean createPoll(Poll poll) {
        User user = userDAO.read(poll.getUser().getId());
        if (user == null) {
            return false;
        }
        poll.setUser(user);
        pollDAO.create(poll);
        return true;

    }

    public void deletePoll(int id) {
        pollDAO.delete(id);
    }

    public void updatePoll(Poll poll) {
        pollDAO.update(poll);
    }

}
