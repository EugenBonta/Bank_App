package com.demo.bankapp.contoller;

import com.demo.bankapp.entity.Account;
import com.demo.bankapp.entity.Operation;
import com.demo.bankapp.repository.impl.AccountRepositoryImpl;
import com.demo.bankapp.repository.impl.OperationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountExpiredException;
import java.util.List;

@RestController
@RequestMapping("operation")
public class OperationController {
    @Autowired
    private OperationRepositoryImpl operationRepository;

    @Autowired
    private AccountRepositoryImpl accountRepository;

    @GetMapping
    public List <Operation> getAll() {
        return operationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Operation getById(@PathVariable Long id){
        return operationRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Operation operation) {
        operationRepository.create(operation);
        return accountRepository.operate(operation.getAccountId(), operation.getAmount());
    }

    @GetMapping("/find_by_date/{date}")
    public List<Operation> findByDate(@PathVariable String date) {
        return operationRepository.findByDate(date);
    }

    @GetMapping("/find_by_idnp/{idnp}")
    public List<Operation> findByIdnp(@PathVariable String idnp) {
        return operationRepository.findByIdnp(idnp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        Operation operation = operationRepository.findById(id);
        accountRepository.operate(operation.getAccountId(), operation.getAmount() * -1);
        operationRepository.delete(id);
    }

    @GetMapping("/exists/{id}")
    public Boolean operationExists(@PathVariable Long id){
        return operationRepository.operationExists(id);
    }

    @GetMapping("transfer/{{idFrom}/{idTo}}")
    public Boolean transfer(@PathVariable Long idFrom, @PathVariable Long idTo, Double amount){
        return operationRepository.transfer(idFrom, idTo, amount);
    }

}

