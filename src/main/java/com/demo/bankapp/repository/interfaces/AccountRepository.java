package com.demo.bankapp.repository.interfaces;

import com.demo.bankapp.entity.Account;
import com.demo.bankapp.entity.Client;

import java.util.List;

public interface AccountRepository {
    void create(Account acount);
    List<Account> findAll();
    Account findById(Long idnp);
    void update(Long id, Client client);
    void delete(Long id);
    boolean accountExist(Long id);
}
