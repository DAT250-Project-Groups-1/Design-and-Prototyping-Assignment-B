package com.dat250.feedapp.controllers;

import com.dat250.feedapp.models.Vote;
import com.dat250.feedapp.services.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoteController {

    @Autowired
    private VotingService votingService;

    @GetMapping("/votes")
    List<Vote> getVotes() {
        return votingService.readAllVotes();
    }

    @GetMapping("/vote/{id}")
    Vote getVote(@PathVariable(name = "id") int id) {
        return votingService.readVote(id);
    }

    @PostMapping("/vote")
    Vote postVote(@RequestBody Vote vote) {
        votingService.addVoteToPoll(vote);
        return vote;
    }
}
