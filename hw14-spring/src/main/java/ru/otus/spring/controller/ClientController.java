package ru.otus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.otus.spring.transfer.ClientTransferObject;
import ru.otus.spring.transfer.TransferObjectConverter;
import ru.otus.spring.service.DBServiceClient;

import static java.util.stream.Collectors.toList;

@Controller
public class ClientController {

    private final DBServiceClient dbServiceClient;
    private final TransferObjectConverter transferObjectConverter;

    public ClientController(DBServiceClient dbServiceClient, TransferObjectConverter transferObjectConverter) {
        this.dbServiceClient = dbServiceClient;
        this.transferObjectConverter = transferObjectConverter;
    }

    @GetMapping("/clients")
    public String getClients(Model model) {
        model.addAttribute(
                "clients",
                dbServiceClient.findAll().stream().map(transferObjectConverter::toTransferObject).collect(toList())
        );
        return "clients";
    }

    @PostMapping("/clients/add")
    public RedirectView addClient(@ModelAttribute ClientTransferObject clientTransferObject) {
        var client = transferObjectConverter.toClient(clientTransferObject);
        dbServiceClient.saveClient(client);
        return new RedirectView("/clients", true);
    }

}
