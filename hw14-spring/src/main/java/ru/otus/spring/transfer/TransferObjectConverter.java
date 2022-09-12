package ru.otus.spring.transfer;

import ru.otus.spring.model.Client;

public interface TransferObjectConverter {
    Client toClient(ClientTransferObject clientTransferObject);
    ClientTransferObject toTransferObject(Client client);
}
