package com.andres_silva.demo.controllers;

import com.andres_silva.demo.domain.Client;
import com.andres_silva.demo.domain.Deposit;
import com.andres_silva.demo.forms.DepositForm;
import com.andres_silva.demo.forms.ClienteForm;
import com.andres_silva.demo.converters.DepositToDepositForm;
import com.andres_silva.demo.converters.ClientToClientForm;
import com.andres_silva.demo.services.DepositService;
import com.andres_silva.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;


@Controller
public class DepositController {
    private DepositService depositService;
    private ClientService clientService;
    private DepositToDepositForm depositToDepositForm;
    private ClientToClientForm clientToClientForm;

    @Autowired
    public void setDepositToDepositForm(DepositToDepositForm depositToDepositForm) {
        this.depositToDepositForm = depositToDepositForm;
    }

    @Autowired
    public void setDepositService(DepositService depositService) {
        this.depositService = depositService;
    }

    @Autowired
    public void setClientToClientForm(ClientToClientForm clientToClientForm) {
        this.clientToClientForm = clientToClientForm;
    }


    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }


    @RequestMapping("/")
    @Scope("session")
    public String redirToList() {
        return "redirect:/client/list";
    }

    @RequestMapping({"/client/list", "/client"})
    public String listItem(Model model) {
        model.addAttribute("deposit", depositService.listAll());
        model.addAttribute("clients", clientService.listAll());
        return "list";
    }

    @RequestMapping("/client/show/{id}")
    public String getItem(@PathVariable String id, Model model) {
        model.addAttribute("deposit", depositService.getById(Long.valueOf(id)));
        return "show";
    }

    @RequestMapping("client/edit/{id}/{ids}")
    @Scope("session")
    public String edit(@PathVariable String id, @PathVariable String ids, Model model) {
        Deposit deposit = depositService.getById(Long.valueOf(id));
        DepositForm depositForm = depositToDepositForm.convert(deposit);
        Client client = clientService.getById(Long.valueOf(ids));
        ClienteForm clientForm = clientToClientForm.convert(client);
        model.addAttribute("depositForm", depositForm);
        model.addAttribute("clientForm", clientForm);
        return "editForm";
    }

    @RequestMapping("/client/new")
    public String newItem(Model model) {
        model.addAttribute("depositForm", new DepositForm());
        model.addAttribute("clientForm", new ClienteForm());
        return "createForm";
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public String saveOrUpdateItem(@Valid DepositForm depositForm, ClienteForm clienteForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "createForm";
        }
        Client savedClient = clientService.saveOrUpdateClientForm(clienteForm);
        depositForm.setClient(savedClient);
        Deposit savedDeposit = depositService.saveOrUpdateItemForm(depositForm);
        return "redirect:/client/list";
    }

    @RequestMapping("/client/delete/{id}")
    public String delete(@PathVariable String id) {
        depositService.delete(Long.valueOf(id));
        return "redirect:/client/list";
    }


    @RequestMapping("/get_identity/{nationalId}")
    @ResponseBody
    public HashMap<String, String> nationalIdentity(@PathVariable String nationalId) {
        Client searchClient = clientService.findByNationalId(nationalId);

        HashMap<String, String> client = new HashMap<>();

        if(searchClient.getName() != null){
            client.put("user_name", clientService.checkNullObjects(searchClient.getName()));
            client.put("user_identity", clientService.checkNullObjects(searchClient.getNationalId()));

        }

        return client;
    }
}
