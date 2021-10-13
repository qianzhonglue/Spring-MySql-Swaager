package com.clf.sim.api.demoapi.device;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    
    @Autowired
    private DeviceRepository deviceRepository;

    public Device linkDevice(String serial) {
        if (serial == null || serial.isEmpty())
            return null;
            
        Device device = deviceRepository.findDeviceBySeial(serial);

        if (device == null){
            device = new Device();
            device.setSerial(serial);
            device.setState(0);

            device = deviceRepository.save(device);
        }

        return device;
    }

    public Device updateDevice(Device device) {

        device = deviceRepository.save(device);

        return device;
    }

    public Device findDevice(Integer devId) {
        Optional<Device> optional = deviceRepository.findById(devId);
        if (optional.isEmpty()) {
            return null;
        }

        return optional.get();
    }
}
