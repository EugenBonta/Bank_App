package com.demo.bankapp.repository.impl;

import com.demo.bankapp.entity.Account;
import com.demo.bankapp.entity.Client;
import com.demo.bankapp.repository.interfaces.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public void create(Account acount) {

    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(Long idnp) {
        return null;
    }

    @Override
    public void update(Long id, Client client) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean accountExist(Long id) {
        return false;
    }
}
