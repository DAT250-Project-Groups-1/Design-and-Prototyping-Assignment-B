package com.dat250.feedapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "polls")
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
    @ManyToOne()
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "poll", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Vote> votes;

}