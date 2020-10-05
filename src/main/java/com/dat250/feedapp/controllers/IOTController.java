package com.dat250.feedapp.controllers;

import com.dat250.feedapp.models.Vote;
import com.dat250.feedapp.services.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class IOTController {

    @Autowired
    private IOTController iotController;

    @GetMapping("/iotDevices")
    List<IOTDevice> getIOTDevices(){
        return iotController.readAllIOTDevices();
    }

    @GetMapping("/iotDevices/{id}")
    IOTDevice getIOTDevice(@PathVariable(name = "id") int id){
        return IOTDeviceService.readIOTDeviceById(id);
    }

    @PostMapping("/iotDevices")
    IOTDevice postIOTDevice(@RequestBody IOTDevice iotDevice){

    }
}
