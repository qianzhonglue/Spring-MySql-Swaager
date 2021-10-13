package com.clf.sim.api.demoapi.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All Details about the Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identifier of Account, 0:has not been registered in table", required = true)
    private Integer accountId;

    @ApiModelProperty(notes = "Name of Account", required = true)
    private String  accountName;

    @ApiModelProperty(notes = "Identifier of Device, 0:has not been registerd in table", required = true)
    private Integer devId;
    @ApiModelProperty(notes = "Serial Number of Device", required = true)
    private String  serial;

    @ApiModelProperty(notes = "Created Date of Account , Formate = yyyy-MM-DD", required = true)
    private String  createDate;
    @ApiModelProperty(notes = "Updated Date of Account, Formate = yyyy-MM-DD", required = true)
    private String  updateDate;
    @ApiModelProperty(notes = "Gender of Account, -1:Unknown, 0:Male, 1:Female", required = true)
    private Integer gender;
    @ApiModelProperty(notes = "Born Year of Account, 0:Unknown", required = true)
    private Integer bornYear;
    @ApiModelProperty(notes = "Height of Account, Unit:cm, 0:Unknown", required = true)
    private Integer height;
    @ApiModelProperty(notes = "Weight of Account, Unit:Kg, 0:Unknown", required = true)
    private Integer weight;
    @ApiModelProperty(notes = "true: removed, false: exist", required = true)
    private Boolean remove;

    public int getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public Integer getDevId() {
        return devId;
    }

    public String getSerial() {
        return serial;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getBornYear() {
        return bornYear;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public Boolean getRemove() {
        return remove;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }
}
