package com.dat250.feedapp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "iot_votes")
public class IoTVote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "count_yes")
    private int countYes;

    @Column(name = "count_no")
    private int countNo;

    @OneToOne
    private Poll poll;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private IoTDevice ioTDevice;

}
