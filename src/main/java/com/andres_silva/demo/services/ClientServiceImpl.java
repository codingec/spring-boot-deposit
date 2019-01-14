package com.andres_silva.demo.services;

import com.andres_silva.demo.converters.ClientFormToClient;
import com.andres_silva.demo.domain.Client;
import com.andres_silva.demo.forms.ClienteForm;
import com.andres_silva.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    private ClienteRepository clienteRepository;
    private ClientFormToClient clientFormToClient;

    @Autowired
    public ClientServiceImpl(ClienteRepository clienteRepository, ClientFormToClient clientFormToClient) {
        this.clienteRepository = clienteRepository;
        this.clientFormToClient = clientFormToClient;
    }


    @Override
    public List<Client> listAll() {
        List<Client> items = new ArrayList<>();
        clienteRepository.findAll().forEach(items::add); //fun with Java 8
        return items;
    }

    @Override
    public Client getById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Client findByNationalId(String nationalId) {
        return clienteRepository.findByNationalId(nationalId);
    }


    @Override
    public Client saveOrUpdate(Client client) { clienteRepository.save(client); return client; }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);

    }

    @Override
    public Client saveOrUpdateClientForm(ClienteForm clienteForm) {
        Client savedClient = saveOrUpdate(clientFormToClient.convert(clienteForm));
        return savedClient;
    }

    @Override
    public String checkNullObjects(String data) {
        String result = data != null? data : "0";
        return result;
    }


}
