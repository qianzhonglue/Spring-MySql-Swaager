package com.clf.sim.api.demoapi.data;

import com.clf.sim.api.demoapi.account.Account;
import com.clf.sim.api.demoapi.account.AccountService;
import com.clf.sim.api.demoapi.device.Device;
import com.clf.sim.api.demoapi.device.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private DeviceService devService;

    @Autowired 
    private AccountService accService;

    public Boolean addNewData(Data data) {
        if (data.getSerial() == null || data.getSerial().equals("")) {
            return false;
        } else if (data.getAccountName() == null || data.getAccountName().equals("")) {
            return false;
        } 

        Device device = devService.linkDevice(data.getSerial());
        if (device == null) {
            return false;
        }

        data.setDevId(device.getDevId());

        Account account = accService.linkAccount(device.getDevId(), data.getAccountName());
        if (account == null) {
            return false;
        }

        data.setAccountID(account.getAccountId());

        dataRepository.save(data);

        return true;
    }
    
}
