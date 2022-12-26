package com.demo.bankapp.contoller;

import com.demo.bankapp.entity.Client;
import com.demo.bankapp.repository.impl.ClientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  http://localhost:8080/swagger-ui/index.html

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientRepositoryImpl clientRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Client client){
        clientRepository.create(client);
    }

    @GetMapping
    public List <Client> getAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/{idnp}")
    public Client getByIdnp(@PathVariable String idnp){
        return clientRepository.findByIdnp(idnp);
    }
}
