package com.andres_silva.demo.repositories;


import com.andres_silva.demo.domain.Deposit;
import org.springframework.data.repository.CrudRepository;


public interface DepositRepository extends CrudRepository<Deposit, Long> {
    public Deposit findByClient(Long client);

}
