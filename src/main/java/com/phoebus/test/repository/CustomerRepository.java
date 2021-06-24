package com.phoebus.test.repository;

import com.phoebus.test.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Iterable<Customer> findCustomerByAccounts_AccountNumber(Integer accountNumber);

}
