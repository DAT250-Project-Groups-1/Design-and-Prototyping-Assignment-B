package com.dat250.feedapp.repositories;

import com.dat250.feedapp.models.Poll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Integer> {
}
