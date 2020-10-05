package com.dat250.feedapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "iot_devices")
public class IoTDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne
    private Poll poll;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "ioTDevice", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<IoTVote> ioTVotes;



}
