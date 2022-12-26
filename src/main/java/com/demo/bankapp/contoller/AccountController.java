package com.demo.bankapp.contoller;

import com.demo.bankapp.entity.Account;
import com.demo.bankapp.repository.impl.AccountRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountExpiredException;
import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountRepositoryImpl accountRepository;

    @GetMapping
    public List <Account> getAll() {
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id){
        return accountRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Account account) {
        accountRepository.create(account);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Account account) {
        accountRepository.update(id, account);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        accountRepository.delete(id);
    }

    @GetMapping("/exists/{id}")
    public Boolean accountExists(@PathVariable Long id){
        return accountRepository.accountExist(id);
    }

}
