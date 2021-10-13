package com.clf.sim.api.demoapi.account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer>{
    
    @Query(value = "SELECT a FROM Account a WHERE a.serial=?1 AND a.remove=?2")
    List<Account> findAccountsBySerialAndExist(String serial, Boolean remove);

    @Query(value = "SELECT a FROM Account a WHERE a.serial=?1")
    List<Account> findAccountsBySerial(String serial);

    @Query(value = "SELECT a FROM Account a WHERE a.devId=?1 AND a.remove=?2")
    List<Account> findAccountsByDevIdAndExist(Integer devId, Boolean remove);

    @Query(value = "SELECT a FROM Account a WHERE a.devId=?1")
    List<Account> findAccountsByDevId(Integer devId);

    @Query(value = "SELECT a FROM Account a WHERE a.devId=?1 AND a.accountName LIKE CONCAT('%',?2,'%') AND a.remove=?3")
    List<Account> findExistingAccount(Integer devId, String accountName, Boolean remove);


}
