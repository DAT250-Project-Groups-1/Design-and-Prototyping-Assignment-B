package com.dat250.feedapp.services;

import com.dat250.feedapp.models.Poll;
import com.dat250.feedapp.repositories.PollDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {
    @Autowired
    private PollDAO pollDAO;

    public List<Poll> readAllPolls() {
        return pollDAO.read();
    }

    public Poll readPoll(int id) {
        return pollDAO.read(id);
    }

    public void createPoll(Poll poll) {
        pollDAO.create(poll);
    }

    public void deletePoll(int id) {
        pollDAO.delete(id);
    }

    public void updatePoll(Poll poll) {
        pollDAO.update(poll);
    }

}
