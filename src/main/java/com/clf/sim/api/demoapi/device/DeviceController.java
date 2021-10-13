package com.clf.sim.api.demoapi.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/api/device")
public class DeviceController {
    
    @Autowired
    private DeviceService service;

    @GetMapping(value = "/link", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Link Device by Serial, If device not exist create new device item",
                  response = Device.class)
    public @ResponseBody Device
    linkDevice(@ApiParam(value = "serial", required = true) @RequestParam String serial) {
        return service.linkDevice(serial);
    }

    @PutMapping
    @ApiOperation(value = "update device", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Device
    updateDevice(@ApiParam(required = true) @RequestBody Device device) {
        return service.updateDevice(device);
    }

}
