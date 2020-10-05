package com.dat250.feedapp.controllers;

import java.util.List;

import com.dat250.feedapp.models.IoTDevice;
import com.dat250.feedapp.models.IoTVotes;
import com.dat250.feedapp.services.IoTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class IoTController {

  @Autowired
  private IoTService iotService;

  @GetMapping("/iot")
  List<IoTDevice> getIOTDevices() {
    return iotService.readAllIoTDevices();
  }

  @GetMapping("/iot/{id}")
  IoTDevice getIOTDevice(@PathVariable(name = "id") int id) {
    return iotService.readIoTDeviceById(id);
  }

  @PostMapping("/iot")
  IoTDevice postIOTDevice(@RequestBody IoTDevice iotDevice) {
    iotService.createIoTDevice(iotDevice);
    return iotDevice;
  }

  @DeleteMapping("/iot/{id}")
  void deleteIoTDevice(@PathVariable(name = "id") int id) {
    iotService.deleteIoTDevice(id);
  }

  @PutMapping("/iot")
  IoTDevice putIoTDevice(@RequestBody IoTDevice ioTDevice) {
    iotService.updateIoTDevice(ioTDevice);
    return ioTDevice;
  }

  @PostMapping("/iot/votes")
  void postVote(@RequestBody IoTVotes vote) {
    iotService.addIoTVotes(vote);
  }
}