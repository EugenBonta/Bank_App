package com.demo.bankapp.contoller;

import com.demo.bankapp.entity.Operation;
import com.demo.bankapp.repository.impl.OperationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.AccountExpiredException;
import java.util.List;

@RestController
@RequestMapping("operation")
public class OperationController {
    @Autowired
    private OperationRepositoryImpl operationRepository;

    @GetMapping
    public List <Operation> getAll() {
        return operationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Operation getById(@PathVariable Long id){
        return operationRepository.findById(id);
    }

}
