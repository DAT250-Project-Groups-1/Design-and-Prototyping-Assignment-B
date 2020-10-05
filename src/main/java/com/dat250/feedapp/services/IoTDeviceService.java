package com.dat250.feedapp.services;

import com.dat250.feedapp.models.IoTDevice;
import com.dat250.feedapp.repositories.IoTDeviceDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IoTDeviceService {

    @Autowired
    private IoTDeviceDAO userDAO;

    public List<IoTDevice> readAllIoTDevices() {
        return IoTDeviceDAO.read();
    }

    public IoTDevice readIoTDeviceById(int id) {
        return IoTDeviceDAO.read(id);
    }

    public void createIoTDevice(IoTDevice ioTDevice) {
        IoTDeviceDAO.create(ioTDevice);
    }

    public void deleteIoTDevice(int id) {
        IoTDeviceDAO.delete(id);
    }

    public void updateIoTDevice(IoTDevice ioTDevice) {
        IoTDeviceDAO.update(ioTDevice);
    }