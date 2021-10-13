package com.clf.sim.api.demoapi.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeviceRepository extends JpaRepository<Device, Integer>{
    
    @Query(value = "SELECT d FROM Device d WHERE d.serial=?1")
    Device findDeviceBySeial(String serial);
}
