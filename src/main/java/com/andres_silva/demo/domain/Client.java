package com.andres_silva.demo.domain;


import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    private Long id;
    @Column(name = "client_name", length =255)
    @NotEmpty(message = "*Please provide your name! This field can not be empty!")
    private String name;
    @Column(name = "identity", length =255)
    @NotEmpty(message = "*Please provide your region! This field can not be empty!")
    private String nationalId;

    public Client(){

    }

    public Client(String name, String nationalId){
        this.name = name;
        this.nationalId = nationalId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
