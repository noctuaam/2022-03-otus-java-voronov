package ru.otus.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.otus.spring.model.Client;
import ru.otus.spring.repository.ClientRepository;
import ru.otus.spring.sessionmanager.TransactionManager;

import java.util.List;

@Service
public class DbServiceClientImpl implements DBServiceClient {
    private static final Logger log = LoggerFactory.getLogger(DbServiceClientImpl.class);

    private final TransactionManager transactionManager;
    private final ClientRepository clientRepository;

    public DbServiceClientImpl(TransactionManager transactionManager, ClientRepository clientRepository) {
        this.transactionManager = transactionManager;
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClient(Client client) {
        return transactionManager.doInTransaction(() -> {
            Client res = clientRepository.save(client);
            log.info("saved client: {}", res);
            return res;
        });
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
