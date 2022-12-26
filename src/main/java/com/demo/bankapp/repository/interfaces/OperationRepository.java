package com.demo.bankapp.repository.interfaces;

import com.demo.bankapp.entity.Operation;

import java.util.List;

public interface OperationRepository {
    void create(Operation operation);
    List<Operation> findAll();
    List<Operation> findByDate(String date);
    Operation findById(Long id);
    List<Operation> findByIdnp(String idnp);
    void delete(Long id);
    boolean operationExists(Long id);
    boolean transfer(Long id1, Long id2, Double amount);
}
