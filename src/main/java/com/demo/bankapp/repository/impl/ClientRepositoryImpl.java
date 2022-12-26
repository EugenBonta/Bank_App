package com.demo.bankapp.repository.impl;

import com.demo.bankapp.entity.Client;
import com.demo.bankapp.repository.interfaces.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Client client) {
        jdbcTemplate.update(
                "insert into client values(?, ?, ?, ?, ?)",
                client.getIdnp(), client.getFirstName(), client.getLastName(),
                client.getEmail(), client.getPhoneNumber());
    }

    @Override
    public List<Client> findAll() {
        return jdbcTemplate.query("select * from client", (client, rowNum) ->
                new Client(
                        client.getString("idnp"),
                        client.getString("first_name"),
                        client.getString("last_name"),
                        client.getString("email"),
                        client.getString("phone_number")
                ));
    }

    @Override
    public Client findByIdnp(String idnp) {
        return jdbcTemplate.queryForObject("select * from client where idnp = ?",
                (student, rowNum) ->
                        new Client(
                                student.getString("idnp"),
                                student.getString("first_name"),
                                student.getString("last_name"),
                                student.getString("email"),
                                student.getString("phone_number")
                        ), idnp);
    }

    @Override
    public Client update(String idnp, Client client) {
        jdbcTemplate.update(
                "update client set idnp = ?, first_name = ?, last_name = ?, email = ?, phone_number = ? where idnp = ?",
                client.getIdnp(), client.getFirstName(), client.getLastName(), client.getEmail(), client.getPhoneNumber(), idnp);

        return client;
    }

    @Override
    public void delete(String idnp) {
        jdbcTemplate.update(
                "delete from client where idnp = ?", idnp);
    }

    @Override
    public boolean clientExist(String idnp) {
        Integer count = jdbcTemplate.queryForObject("select count(*) from client where idnp = ?",
                Integer.class, idnp);

        return count > 0;
    }
}
