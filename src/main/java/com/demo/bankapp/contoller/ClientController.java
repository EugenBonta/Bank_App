package com.demo.bankapp.contoller;

import com.demo.bankapp.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @GetMapping
    public String getAll() {
        return "it works";
//        return findAll();
    }

//    @GetMapping("/{idnp}")
//    public Client getByIdnp(@PathVariable String idnp) {
//
//    }

}
