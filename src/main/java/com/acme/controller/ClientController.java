package com.acme.controller;

import com.acme.model.ResultEnvelope;
import com.acme.model.entity.Client;
import com.acme.service.ClientService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService  clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public ResultEnvelope<List<Client>> getAllClients(){

        return ResultEnvelope.ok(clientService.getAll());
    }



}
