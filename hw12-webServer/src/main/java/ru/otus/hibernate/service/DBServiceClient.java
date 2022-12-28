package ru.otus.hibernate.service;

import ru.otus.hibernate.model.Client;

import java.util.List;
import java.util.Optional;

public interface DBServiceClient {

    Client saveClient(Client client);

    Optional<Client> getClient(long id);

    Optional<Client> findByLogin(String login);

    List<Client> findAll();

}
