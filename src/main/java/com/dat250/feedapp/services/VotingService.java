package com.dat250.feedapp.services;

import com.dat250.feedapp.models.Poll;
import com.dat250.feedapp.models.User;
import com.dat250.feedapp.models.Vote;
import com.dat250.feedapp.repositories.PollDAO;
import com.dat250.feedapp.repositories.UserDAO;
import com.dat250.feedapp.repositories.VoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingService {

    @Autowired
    private PollDAO pollDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private VoteDAO voteDAO;

    public List<Vote> readAllVotes() {
        return voteDAO.read();
    }

    public Vote readVote(int id) {
        return voteDAO.read(id);
    }

    public boolean addVoteToPoll(Vote vote) {
        User user = userDAO.read(vote.getUser().getId());
        Poll poll = pollDAO.read(vote.getPoll().getId());
        if (user == null || poll == null) {
            return false;
        }
        if (vote.isYes()) {
            poll.setCountYes(poll.getCountYes() + 1);
        } else {
            poll.setCountNo(poll.getCountNo() + 1);
        }
        vote.setUser(user);
        vote.setPoll(poll);
        voteDAO.create(vote);
        return true;
    }
}
