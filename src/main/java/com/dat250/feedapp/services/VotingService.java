package com.dat250.feedapp.services;

import com.dat250.feedapp.models.Vote;
import com.dat250.feedapp.repositories.VoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingService {

    @Autowired
    private VoteDAO voteDAO;

    public List<Vote> readAllVotes() {
        return voteDAO.read();
    }

    public Vote readVote(int id) {
        return voteDAO.read(id);
    }

    public void addVoteToPoll(Vote vote) {
        return;
    }
}
