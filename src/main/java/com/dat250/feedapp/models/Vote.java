package com.dat250.feedapp.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // Json value is yes
    @Column(name = "is_yes")
    private boolean isYes;

    @ManyToOne
    private User user;

    @ManyToOne
    private Poll poll;
}
