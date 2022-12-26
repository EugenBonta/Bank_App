package com.demo.bankapp.repository.interfaces;

import com.demo.bankapp.entity.Operation;

import java.util.List;

public interface OperationRepository {
    void create(Operation operation);
    List<Operation> findAll();
    Operation findByDate(String date);
    Operation findById(Long id);
    Operation findByIdnp(String idnp);
    void delete(Long id);
    boolean operationExist(Long id);
    boolean transfer(Long id1, Long id2, Double amount);
}
