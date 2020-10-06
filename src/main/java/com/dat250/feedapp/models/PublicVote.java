package com.dat250.feedapp.models;

import lombok.Data;

import javax.persistence.*;

@Data
public class PublicVote {

  @Column(name = "is_yes")
  private boolean isYes;

  @OneToOne
  private Poll poll;
}