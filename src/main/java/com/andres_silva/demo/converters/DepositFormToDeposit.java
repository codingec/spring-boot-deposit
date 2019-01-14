package com.andres_silva.demo.converters;

import com.andres_silva.demo.domain.Deposit;
import com.andres_silva.demo.forms.DepositForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class DepositFormToDeposit implements Converter<DepositForm, Deposit> {

    @Override
    public Deposit convert(DepositForm depositForm) {
        Deposit deposit = new Deposit();

        if (depositForm.getId() != null  && !StringUtils.isEmpty(depositForm.getId())) {
            deposit.setId(new Long(depositForm.getId()));
        }
        deposit.setClient(depositForm.getClient());
        deposit.setAmount(depositForm.getAmount());
        deposit.setDate(depositForm.getDate());
        return deposit;
    }

}
