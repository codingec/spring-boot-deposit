package com.andres_silva.demo.repositories;

import com.andres_silva.demo.domain.Client;
import org.springframework.data.repository.CrudRepository;


public interface ClienteRepository extends CrudRepository<Client, Long> {

    public Client findByNationalId(String nationalId);

}
