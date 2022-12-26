package com.demo.bankapp.repository.impl;

import com.demo.bankapp.entity.Operation;
import com.demo.bankapp.repository.interfaces.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class OperationRepositoryImpl implements OperationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Operation operation) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        jdbcTemplate.update(
                "insert into operation values (null, ?, ?, ?)",
                operation.getAccountId(), operation.getAmount(), strDate);
    }

    @Override
    public List<Operation> findAll() {
        return jdbcTemplate.query("select * from operation", (operation, rowNum) ->
                new Operation(
                        operation.getLong("id"),
                        operation.getLong("account_id"),
                        operation.getDouble("amount"),
                        operation.getString("date")

                ));
    }

    @Override
    public List<Operation> findByDate(String date) {
        return jdbcTemplate.query("select * from operation where date like ?",
                (operation, rowNum) ->
                    new Operation(
                            operation.getLong("id"),
                            operation.getLong("account_id"),
                            operation.getDouble("amount"),
                            operation.getString("date")
                    ), date + "%");
    }

    @Override
    public Operation findById(Long id) {
        return jdbcTemplate.queryForObject("select * from operation where id = ?",
                (operation, rowNum) ->
                        new Operation(
                                operation.getLong("id"),
                                operation.getLong("account_id"),
                                operation.getDouble("amount"),
                                operation.getString("date")
                        ), id);
    }

    @Override
    public List<Operation> findByIdnp(String idnp) {
        return jdbcTemplate.query(
                "select * from operation inner join account on operation.account_id = account.id where account.client_idnp = ?",
                (operation, rowNum) ->
                        new Operation(
                                operation.getLong("id"),
                                operation.getLong("account_id"),
                                operation.getDouble("amount"),
                                operation.getString("date")
                        ), idnp);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(
                "delete from operation where id = ?", id);
    }

    @Override
    public boolean operationExists(Long id) {
        Integer count = jdbcTemplate.queryForObject("select count(*) from operation where id = ?",
                Integer.class, id);

        return count > 0;
    }
    @Override
    public boolean transfer(Long idFrom, Long idTo, Double amount){
        String currencyFrom = jdbcTemplate.queryForObject("select currency from account where id = ?", String.class, idFrom);
        String currencyTo = jdbcTemplate.queryForObject("select currency from account where id = ?",  String.class, idTo);
        if (currencyFrom.equals(currencyTo)){
            jdbcTemplate.update(
                    "update account set funds = funds - ? where id = ?",
                    amount, idFrom);
            jdbcTemplate.update(
                    "update account set funds = funds + ? where id = ?",
                    amount, idTo);
            return true;
        }
        return false;
    }
}
