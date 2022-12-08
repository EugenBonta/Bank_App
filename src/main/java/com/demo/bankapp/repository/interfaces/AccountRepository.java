package com.demo.bankapp.repository.interfaces;

import com.demo.bankapp.entity.Account;
import com.demo.bankapp.entity.Client;

import java.util.List;

public interface AccountRepository {
    void create(Account acount);
    List<Account> findAll();
    Account findById(Long id);
    void update(Long id, Account account);
    void delete(Long id);
    boolean accountExist(Long id);
}
