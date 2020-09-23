package com.dat250.feedapp.services;

import java.util.List;

import com.dat250.feedapp.models.Poll;
import com.dat250.feedapp.models.User;
import com.dat250.feedapp.models.Vote;
import com.dat250.feedapp.repositories.PollRepository;
import com.dat250.feedapp.repositories.UserRepository;
import com.dat250.feedapp.repositories.VoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingService {

  @Autowired
  private PollRepository pollRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private VoteRepository voteRepository;

  public List<Poll> getAllPolls() {
    return pollRepository.findAll();
  }

  public Poll getPollById(int id) {
    return pollRepository.getOne(id);
  }

  public List<Vote> getAllVotes() {
    return voteRepository.findAll();
  }

  public boolean addVoteToPoll(Vote vote) {
    return true;
  }
}
