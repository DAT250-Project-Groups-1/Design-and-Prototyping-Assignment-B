package com.dat250.feedapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "mail")
    private String mail;
    @Column(name = "is_admin")
    private boolean isAdmin;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Poll> polls;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Vote> votes;
}
