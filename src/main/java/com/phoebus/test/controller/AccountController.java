package com.phoebus.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phoebus.test.entity.Account;
import com.phoebus.test.entity.Customer;
import com.phoebus.test.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private ObjectMapper objectMapper = new ObjectMapper();
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> findByCustomerId(@PathVariable Long customerId) {
        return accountService.findByAccountNumber(customerId);
    }

    @PostMapping("/new")
    public Account createNewAccount(@RequestBody Customer customer) {
        return accountService.createNewAccount(customer);
    }
}
