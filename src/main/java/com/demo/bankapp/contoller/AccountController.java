package com.demo.bankapp.contoller;

import com.demo.bankapp.entity.Account;
import com.demo.bankapp.repository.impl.AccountRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
