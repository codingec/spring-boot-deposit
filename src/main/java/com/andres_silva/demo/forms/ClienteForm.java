package com.andres_silva.demo.forms;


import com.andres_silva.demo.domain.Client;


public class ClienteForm {

    private Long id;
    private String name;
    private String nationalId;

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
