package com.dat250.feedapp.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Proxy;

import java.util.List;

@Entity
@Data
@Table(name = "users")
@Proxy(lazy = false)
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
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Poll> polls;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Vote> votes;
}
