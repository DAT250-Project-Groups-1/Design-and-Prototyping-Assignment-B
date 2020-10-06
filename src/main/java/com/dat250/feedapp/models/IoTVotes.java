package com.dat250.feedapp.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "iot_votes")
public class IoTVotes {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "count_yes")
  private int countYes;

  @Column(name = "count_no")
  private int countNo;

  @ManyToOne
  private Poll poll;

  @ManyToOne
  private IoTDevice ioTDevice;

}