package com.dat250.feedapp.controllers;

import java.util.List;

import com.dat250.feedapp.models.Vote;
import com.dat250.feedapp.services.VotingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

  @Autowired
  private VotingService votingService;

  @GetMapping("/votes")
  List<Vote> getVotes() {
    return votingService.getAllVotes();
  }

  @PostMapping("/vote")
  boolean postVote(@RequestBody Vote vote) {
    return votingService.addVoteToPoll(vote);
  }
}
