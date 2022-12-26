package com.demo.bankapp.repository.impl;

import com.demo.bankapp.entity.Account;
import com.demo.bankapp.repository.interfaces.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account", (account, rowNum) ->
                new Account(
                        account.getLong("id"),
                        account.getString("client_idnp"),
                        account.getString("currency"),
                        account.getDouble("funds")
                ));    }

    @Override
    public Account findById(Long id) {
        return jdbcTemplate.queryForObject("select * from account where id = ?",
                (account, rowNum) ->
                        new Account(
                                account.getLong("id"),
                                account.getString("client_idnp"),
                                account.getString("currency"),
                                account.getDouble("funds")
                        ), id);
    }

    @Override
    public void create(Account account) {
        jdbcTemplate.update(
                "insert into account values(null, ?, ?, ?)",
                account.getClientIdnp(), account.getCurrency(), account.getFunds() );
    }

    @Override
    public void update(Long id, Account account) {
        jdbcTemplate.update(
                "update account set id = ?, client_idnp = ?, currency = ?, funds = ? where id = ?",
                account.getId(), account.getClientIdnp(), account.getCurrency(), account.getFunds(), id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(
                "delete  from account where id = ?", id);
    }

    @Override
    public boolean accountExist(Long id) {
        Integer count = jdbcTemplate.queryForObject("select count(*) from account where id = ?",
                Integer.class, id);

        return count > 0;
    }

    public Account operate(Long accountId, Double amount) {
        jdbcTemplate.update(
                "update account set funds = funds + ? where id = ?",
                amount, accountId);

        return jdbcTemplate.queryForObject("select * from account where id = ?",
                (account, rowNum) ->
                        new Account(
                                account.getLong("id"),
                                account.getString("client_idnp"),
                                account.getString("currency"),
                                account.getDouble("funds")
                        ), accountId);
    }
}
