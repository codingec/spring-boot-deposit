package com.andres_silva.demo.services;

import com.andres_silva.demo.domain.Client;
import com.andres_silva.demo.domain.Deposit;
import com.andres_silva.demo.forms.DepositForm;

import java.util.List;


public interface DepositService {

    List<Deposit> listAll();

    Deposit getById(Long id);

    Deposit findByClient(Client client);

    Deposit saveOrUpdate(Deposit deposit);

    void delete(Long id);

    Deposit saveOrUpdateItemForm(DepositForm depositForm);
}
