package com.clf.sim.api.demoapi.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/api/account")
public class AccountController {
    
    @Autowired
    private AccountService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Append New Account, If devID == 0, first append device, second append account",
                 response = Account.class)
    public @ResponseBody Account
    appendUser(@ApiParam(required = true)@RequestBody Account account) {
        return service.addAccount(account);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Existing Accounts, If accountName is not required returns all existing accounts")
    public @ResponseBody List<Account>
    getExistingAccounts(@ApiParam(required = true) @RequestParam Integer devId,
                        @ApiParam(required = false) @RequestParam(defaultValue = "") String accountName) {
        return service.getExAccountsByName(devId, accountName);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Account", response = Boolean.class)
    public @ResponseBody  Boolean
    updateAccount(@ApiParam(required = true) @RequestBody Account account) {
        return service.updateAccount(account);
    }
}
