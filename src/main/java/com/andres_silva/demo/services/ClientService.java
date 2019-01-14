package com.andres_silva.demo.services;

import com.andres_silva.demo.domain.Client;
import com.andres_silva.demo.forms.ClienteForm;

import java.util.List;


public interface ClientService {

    List<Client> listAll();

    Client getById(Long id);

    Client findByNationalId(String nationalId);

    Client saveOrUpdate(Client client);

    void delete(Long id);

    Client saveOrUpdateClientForm(ClienteForm clienteForm);

    String checkNullObjects(String data);
}
