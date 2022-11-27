package com.demo.bankapp.repository.interfaces;

import com.demo.bankapp.entity.Client;

import java.util.List;

public interface ClientRepository {
    void create(Client client);
    List<Client> findAll();
    Client findByIdnp(String idnp);
    void update(String idnp, Client client);
    void delete(String idnp);
    boolean clientExist(String idnp);
}
