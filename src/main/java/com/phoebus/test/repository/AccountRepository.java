package com.phoebus.test.repository;

import com.phoebus.test.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Iterable<Account> findAccountByCustomers_CustomerId(Long id);

    Optional<Account> findAccountByAccountNumber(Integer accountNumber);

}
