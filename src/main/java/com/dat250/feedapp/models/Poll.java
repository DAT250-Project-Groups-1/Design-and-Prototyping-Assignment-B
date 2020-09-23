package com.dat250.feedapp.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Proxy;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "polls")
@Proxy(lazy = false)
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "question")
    private String question;
    @Column(name = "from_date")
    private Date fromDate;
    @Column(name = "to_date")
    private Date toDate;
    @Column(name = "count_yes")
    private int countYes;
    @Column(name = "count_no")
    private int countNo;
    @Column(name = "code")
    private String code;
    @Column(name = "is_private")
    private boolean isPrivate;

    @JsonIgnore
    @ManyToOne
    @ToString.Exclude
    private User user;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "poll", fetch = FetchType.EAGER)
    private List<Vote> votes;

}