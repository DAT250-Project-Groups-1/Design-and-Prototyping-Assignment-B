package com.dat250.feedapp.controllers;

import com.dat250.feedapp.models.Poll;
import com.dat250.feedapp.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PollController {

    @Autowired
    private PollService pollService;

    @GetMapping("/polls")
    List<Poll> getPolls() {
        return pollService.readAllPolls();
    }

    @GetMapping("/polls/{id}")
    Poll getPoll(@PathVariable(name = "id") int id) {
        return pollService.readPoll(id);
    }

    @DeleteMapping("/polls/{id}")
    void deletePoll(@PathVariable(name = "id") int id) {
        pollService.deletePoll(id);
    }

    @PostMapping("/polls")
    Poll postPoll(@RequestBody Poll poll) {
        boolean success = pollService.createPoll(poll);
        if (!success) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return poll;
    }

    @PutMapping("/polls")
    Poll putPoll(@RequestBody Poll poll) {
        pollService.updatePoll(poll);
        return poll;
    }
}
