package com.dat250.feedapp.services;

import com.dat250.feedapp.models.IoTDevice;
import com.dat250.feedapp.repositories.IoTDeviceDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IoTDeviceService {

    @Autowired
    private IoTDeviceDAO ioTDeviceDAO;

    public List<IoTDevice> readAllIoTDevices() {
        return ioTDeviceDAO.read();
    }

    public IoTDevice readIoTDeviceById(int id) {
        return ioTDeviceDAO.read(id);
    }

    public void createIoTDevice(IoTDevice ioTDevice) {
        ioTDeviceDAO.create(ioTDevice);
    }

    public void deleteIoTDevice(int id) {
        ioTDeviceDAO.delete(id);
    }

    public void updateIoTDevice(IoTDevice ioTDevice) {
        ioTDeviceDAO.update(ioTDevice);
    }
}