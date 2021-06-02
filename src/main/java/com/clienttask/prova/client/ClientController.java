package com.clienttask.prova.client;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {

    @Autowired
    private final ClientService clientService;


    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client){

        Client client1 = clientService.save(client);

        return new ResponseEntity<>(client1, HttpStatus.CREATED);
    }

    @GetMapping("{clientId}")
    public ResponseEntity<Client> findById(@PathVariable("clientId") Long clientId){

        Client client = clientService.findById(clientId);

        return  new ResponseEntity<>(client, HttpStatus.OK);
    }


}
