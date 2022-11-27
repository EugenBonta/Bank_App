package com.demo.bankapp.repository.impl;

import com.demo.bankapp.entity.Client;
import com.demo.bankapp.entity.Operation;
import com.demo.bankapp.repository.interfaces.OperationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperationRepositoryImpl implements OperationRepository {
    @Override
    public void create(Operation operation) {

    }

    @Override
    public List<Operation> findAll() {
        return null;
    }

    @Override
    public Client findByDate(String date) {
        return null;
    }

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public Client findByName(Long id) {
        return null;
    }

    @Override
    public void update(Long id, Operation operation) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean clientExist(Long id) {
        return false;
    }
}
