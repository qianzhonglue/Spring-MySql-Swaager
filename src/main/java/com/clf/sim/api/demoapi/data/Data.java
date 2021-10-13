package com.clf.sim.api.demoapi.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All detail about measure data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identifier of measure data, 0:has not registerd in table", required = true)
    private Integer dataId;

    @ApiModelProperty(notes = "Identifier of Account, 0:has not registerd in table", required = true)
    private Integer accountId;
    @ApiModelProperty(notes = "Name of Account", required = true)
    private String accountName;
    @ApiModelProperty(notes = "Identifier of Device, 0:has not been registerd in table", required = true)
    private Integer devId;
    @ApiModelProperty(notes = "Serial Number of Device", required = true)
    private String serial;
    @ApiModelProperty(notes = "Latest Meal Time before measurement, Format = yyyy-MM-DD HH:mm:ss", required = true)
    private String mealTime;
    @ApiModelProperty(notes = "Measurement Time, Format = HH:mm:ss", required = true)
    private String measTime;
    @ApiModelProperty(notes = "Blood Glucose Level, Unit:mmol/L, 0:failed to measure", required = true)
    private double glucose;
    @ApiModelProperty(notes = "Oxygen saturation, Unit:%, 0:failed to measure", required = true)
    private double spo2;
    @ApiModelProperty(notes = "Heart Beat Rate, Unit : bpm, 0:failed to measure", required = true)
    private Integer rate;

    public int getDataId() {
        return dataId;
    }

    public int getAccountID() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getDevId() {
        return devId;
    }

    public String getSerial() {
        return serial;
    }

    public String getMealTime() {
        return mealTime;
    }

    public String getMeasTime() {
        return measTime;
    }

    public double getGlucose() {
        return glucose;
    }

    public double getSpo2() {
        return spo2;
    }

    public int getRate() {
        return rate;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public void setAccountID(int accountId) {
        this.accountId = accountId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public void setMeasTime(String measTime) {
        this.measTime = measTime;
    }

    public void setGlucose(double glucose) {
        this.glucose = glucose;
    }

    public void setSpo2(double spo2) {
        this.spo2 = spo2;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
