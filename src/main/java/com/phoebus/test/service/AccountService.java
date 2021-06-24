package com.phoebus.test.service;

import com.phoebus.test.entity.Account;
import com.phoebus.test.entity.Customer;
import com.phoebus.test.exception.CustomerNotFoundException;
import com.phoebus.test.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private CustomerService customerService;

    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    public List<Account> findByAccountNumber(Long customerId) {
        return (List<Account>) accountRepository.findAccountByCustomers_CustomerId(customerId);
    }

    public Account createNewAccount(Customer customer) {
        if (customer.getCustomerId() != null) {
            try {
                customer = customerService.findById(customer.getCustomerId());
            } catch (CustomerNotFoundException e) {
                customer.setCustomerId(null);
                customer = customerService.save(customer);
            }
        } else {
            customerService.save(customer);
        }
        Account account = new Account();
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        account.setCustomers(customers);
        account.setAccountNumber(generateNewAccountNumber());
        return accountRepository.save(account);
    }


    private Integer generateNewAccountNumber() {
        boolean isUnique = false;
        Integer testNumber = null;
        while (!isUnique) {
            testNumber = Math.toIntExact(Math.round(Math.random() * 100000));
            isUnique = !accountRepository.findAccountByAccountNumber(testNumber).isPresent();
        }
        return testNumber;
    }
}
