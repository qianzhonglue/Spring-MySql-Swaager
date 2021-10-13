package com.clf.sim.api.demoapi.device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "devices")
@ApiModel(description = "All details about device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identifier of Device, 0: has not been registered in table", required = true)
    private Integer devId;

    @ApiModelProperty(notes = "Serial Number of Device, It's unique value", required = true)
    private String  serial;

    @ApiModelProperty(notes = "License State of Device, 0:Trial, 1:Activation, 2:Deactivation", required = true)
    private Integer state;

    public Integer getDevId() {
        return devId;
    }

    public String getSerial() {
        return serial;
    }

    public Integer getState() {
        return state;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setState(int state) {
        this.state = state;
    }

}
