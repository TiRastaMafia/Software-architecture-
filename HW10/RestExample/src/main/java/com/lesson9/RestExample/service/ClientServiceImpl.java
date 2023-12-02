package com.lesson9.RestExample.service;

import com.lesson9.RestExample.model.Client;
import com.lesson9.RestExample.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client read(int id) {
        return clientRepository.getOne(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}