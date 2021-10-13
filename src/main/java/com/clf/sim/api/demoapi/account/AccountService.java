package com.clf.sim.api.demoapi.account;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.clf.sim.api.demoapi.device.Device;
import com.clf.sim.api.demoapi.device.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accRepository;

    @Autowired
    private DeviceService devService;

    public Account addAccount(Account acc) {
        if (acc == null || (acc.getAccountName() == null || acc.getAccountName().equals(""))) {
            return null;
        }else if (acc.getDevId() == 0 && (acc.getSerial()==null || acc.getSerial().equals(""))) {
            return null;
        } 
        Device device = devService.linkDevice(acc.getSerial());

        if (device.getDevId() != acc.getDevId()) {
            acc.setDevId(device.getDevId());
        }

        Account account = accRepository.save(acc);
        return account;
    }

    public List<Account> getExistingAccounts(Integer devId) {
        if (devId == 0)
            return new ArrayList<>();
        return accRepository.findAccountsByDevIdAndExist(devId, false);
    }

    public List<Account> getExAccountsByName(Integer devId, String accName) {
        if (devId == 0)
            return new ArrayList<>();

        return accRepository.findExistingAccount(devId, accName, false);
    }

    public Boolean updateAccount(Account account) {
        if (account.getAccountId() == 0) {
            return false;
        }
        accRepository.save(account);
        return true;
    }
    
    public Account linkAccount(Integer devId, String accName) {
        List<Account> accounts = accRepository.findExistingAccount(devId, accName, false);
        int nSize = accounts.size();
        int i;

        Device device = devService.findDevice(devId);
        if (device == null) 
            return null;
        Account acc = null;
        for (i = 0; i < nSize - 1; i++) {
            acc = accounts.get(i);
            acc.setRemove(true);
            accRepository.save(acc);
        }

        if (nSize == 0) {
            acc = new Account();
            acc.setDevId(devId);
            acc.setSerial(device.getSerial());
            acc.setAccountName(accName);
            acc.setCreateDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-DD")));
            acc.setUpdateDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-DD")));
            acc.setGender(-1);
            acc.setBornYear(0);
            acc.setHeight(0);
            acc.setWeight(0);
            acc.setRemove(false);

            acc = accRepository.save(acc);
        } else {
            acc = accounts.get(nSize-1);
        }

        return acc;
    }
}
