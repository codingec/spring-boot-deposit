package com.andres_silva.demo.converters;

import com.andres_silva.demo.domain.Deposit;
import com.andres_silva.demo.forms.DepositForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepositToDepositForm implements Converter<Deposit, DepositForm> {
    @Override
    public DepositForm convert(Deposit deposit) {
        DepositForm depositForm = new DepositForm();
        depositForm.setId(deposit.getId());
        depositForm.setClient(deposit.getClient());
        depositForm.setAmount(deposit.getAmount());
        depositForm.setDate(deposit.getDate());
        return depositForm;
    }
}
