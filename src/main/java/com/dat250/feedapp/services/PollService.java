package com.dat250.feedapp.services;

import com.dat250.feedapp.models.Poll;
import com.dat250.feedapp.models.User;
import com.dat250.feedapp.repositories.PollDAO;
import com.dat250.feedapp.repositories.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PollService {

    @Autowired
    private PollDAO pollDAO;

    @Autowired
    private UserDAO userDAO;

    public List<Poll> readAllPolls() {
        return pollDAO.read().stream().map(p -> {
            Poll poll = p.ReturnPoll();
            int yes = poll.getIoTVotes().stream().map(i -> i.getCountYes()).reduce(0, (s, e) -> s + e);
            int no = poll.getIoTVotes().stream().map(i -> i.getCountNo()).reduce(0, (s, e) -> s + e);
            poll.setCountYes(poll.getCountYes() + yes);
            poll.setCountNo(poll.getCountNo() + no);
            return poll;
        }).collect(Collectors.toList());
    }

    public Poll readPoll(int id) {
        Poll poll = (Poll) pollDAO.read(id).ReturnPoll();
        int yes = poll.getIoTVotes().stream().map(i -> i.getCountYes()).reduce(0, (s, e) -> s + e);
        int no = poll.getIoTVotes().stream().map(i -> i.getCountNo()).reduce(0, (s, e) -> s + e);
        poll.setCountYes(poll.getCountYes() + yes);
        poll.setCountNo(poll.getCountNo() + no);
        return poll;
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
