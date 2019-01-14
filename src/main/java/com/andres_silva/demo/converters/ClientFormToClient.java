package com.andres_silva.demo.converters;

import com.andres_silva.demo.domain.Client;
import com.andres_silva.demo.forms.ClienteForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class ClientFormToClient implements Converter<ClienteForm, Client> {

    @Override
    public Client convert(ClienteForm clienteForm) {
        Client client = new Client();
        if (clienteForm.getId() != null  && !StringUtils.isEmpty(clienteForm.getId())) {
            client.setId(new Long(clienteForm.getId()));
        }
        client.setName(clienteForm.getName());
        client.setNationalId(clienteForm.getNationalId());
        return client;
    }

}
