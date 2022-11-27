package com.demo.bankapp.contoller;

import com.demo.bankapp.entity.Client;
import com.demo.bankapp.repository.impl.ClientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientRepositoryImpl clientRepository;

    @GetMapping
    public List <Client> getAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/{idnp}")
    public Client getByIdnp(@PathVariable String idnp){
        return clientRepository.findByIdnp(idnp);
    }

}
