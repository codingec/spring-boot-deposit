package com.andres_silva.demo.services;

import com.andres_silva.demo.domain.Client;
import com.andres_silva.demo.domain.Deposit;
import com.andres_silva.demo.forms.DepositForm;
import com.andres_silva.demo.converters.DepositFormToDeposit;
import com.andres_silva.demo.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DepositServiceImpl implements DepositService {

    private DepositRepository depositRepository;
    private DepositFormToDeposit depositFormToDeposit;

    @Autowired
    public DepositServiceImpl(DepositRepository depositRepository, DepositFormToDeposit depositFormToDeposit) {
        this.depositRepository = depositRepository;
        this.depositFormToDeposit = depositFormToDeposit;
    }


    @Override
    public List<Deposit> listAll() {
        List<Deposit> deposits = new ArrayList<>();
        depositRepository.findAll().forEach(deposits::add); //fun with Java 8
        return deposits;
    }

    @Override
    public Deposit getById(Long id) {
        return depositRepository.findById(id).orElse(null);
    }

    @Override
    public Deposit findByClient(Client client) {
        return depositRepository.findByClient(client.getId());
    }
//
    @Override
    public Deposit saveOrUpdate(Deposit deposit) {
        depositRepository.save(deposit);
        return deposit;
    }

    @Override
    public void delete(Long id) {
        depositRepository.deleteById(id);
    }

    @Override
    public Deposit saveOrUpdateItemForm(DepositForm depositForm) {
        Deposit savedDeposit = saveOrUpdate(depositFormToDeposit.convert(depositForm));
        return savedDeposit;
    }

}
