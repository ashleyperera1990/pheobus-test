package com.phoebus.test.controller;

import com.phoebus.test.entity.Customer;
import com.phoebus.test.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/account/{accountNo}")
    public List<Customer> findByAccountNumber(@PathVariable Integer accountNo) {
        return customerService.findByAccountNumber(accountNo);
    }
}
