package com.dat250.feedapp.controllers;

import com.dat250.feedapp.models.IoTDevice;
import com.dat250.feedapp.services.IoTDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IoTDeviceController {

    @Autowired
    private IoTDeviceService iotDeviceService;

    @GetMapping("/iotDevices")
    List<IoTDevice> getIOTDevices(){
        return iotDeviceService.readAllIoTDevices();
    }

    @GetMapping("/iotDevices/{id}")
    IoTDevice getIOTDevice(@PathVariable(name = "id") int id){
        return iotDeviceService.readIoTDeviceById(id);
    }

    @PostMapping("/iotDevices")
    IoTDevice postIOTDevice(@RequestBody IoTDevice iotDevice){
        iotDeviceService.createIoTDevice(iotDevice);
        return iotDevice;
    }

    @DeleteMapping("/iotDevices/{id}")
    void deleteIoTDevice(@PathVariable(name = "id") int id){
        iotDeviceService.deleteIoTDevice(id);
    }

    @PutMapping("/iotDevices")
    IoTDevice putIoTDevice(@RequestBody IoTDevice ioTDevice){
        iotDeviceService.updateIoTDevice(ioTDevice);
        return ioTDevice;
    }
}
