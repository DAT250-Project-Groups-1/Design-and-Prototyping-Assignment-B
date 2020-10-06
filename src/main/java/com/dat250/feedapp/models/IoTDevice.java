package com.dat250.feedapp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "iot_devices")
public class IoTDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "ioTDevice", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<IoTVotes> ioTVotes;
}
