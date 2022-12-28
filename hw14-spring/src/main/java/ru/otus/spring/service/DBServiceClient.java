package ru.otus.spring.service;

import ru.otus.spring.model.Client;

import java.util.List;

public interface DBServiceClient {

    Client saveClient(Client client);

    List<Client> findAll();

}
