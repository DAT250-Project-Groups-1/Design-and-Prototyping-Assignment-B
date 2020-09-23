package com.dat250.feedapp.controllers;

import java.util.List;

import com.dat250.feedapp.models.Poll;
import com.dat250.feedapp.services.VotingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollController {

  @Autowired
  private VotingService votingService;

  @GetMapping("/polls")
  List<Poll> getPolls() {
    return votingService.getAllPolls();
  }

  @GetMapping("/poll/{id}")
  Poll getPoll(@PathVariable(name = "id") int id) {
    return votingService.getPollById(id);
  }
}
