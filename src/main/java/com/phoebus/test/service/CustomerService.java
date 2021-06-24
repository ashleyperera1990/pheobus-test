package com.phoebus.test.service;

import com.phoebus.test.entity.Customer;
import com.phoebus.test.exception.CustomerNotFoundException;
import com.phoebus.test.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findByAccountNumber(Integer accountNo) {
        return (List<Customer>) customerRepository.findCustomerByAccounts_AccountNumber(accountNo);
    }

    public Customer findById(Long customerId) throws CustomerNotFoundException {
        return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
