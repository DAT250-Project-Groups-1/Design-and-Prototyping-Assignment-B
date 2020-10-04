package com.dat250.feedapp.controllers;

import com.dat250.feedapp.models.Vote;
import com.dat250.feedapp.services.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class VoteController {

    @Autowired
    private VotingService votingService;

    @GetMapping("/votes")
    List<Vote> getVotes() {
        return votingService.readAllVotes();
    }

    @GetMapping("/votes/{id}")
    Vote getVote(@PathVariable(name = "id") int id) {
        return votingService.readVote(id);
    }

    @PostMapping("/votes")
    Vote postVote(@RequestBody Vote vote) {
        boolean success = votingService.addVoteToPoll(vote);
        if (!success) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User and/or poll not found");
        }
        return vote;
    }
}
