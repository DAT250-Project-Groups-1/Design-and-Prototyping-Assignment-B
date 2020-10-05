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

    @Column(name = "poll_id")
    private int pollid;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "iotDevice", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<IoTVote> ioTVotes;



}
