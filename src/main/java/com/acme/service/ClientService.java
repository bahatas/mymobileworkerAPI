package com.acme.service;

import com.acme.model.ClientDto;
import com.acme.model.entity.Client;
import com.acme.repository.ClientRepository;
import com.acme.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    MapperUtil mapperUtil;

    public List<ClientDto> getAll(){

        List<Client> all = clientRepository.findAll();
        return all.stream().map(e -> mapperUtil.convert(e, new ClientDto())).collect(Collectors.toList());

    }


}
