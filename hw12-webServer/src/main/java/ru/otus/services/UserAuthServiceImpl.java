package ru.otus.services;

import ru.otus.hibernate.service.DBServiceClient;

public class UserAuthServiceImpl implements UserAuthService {

    private final DBServiceClient dbServiceClient;

    public UserAuthServiceImpl(DBServiceClient dbServiceClient) {
        this.dbServiceClient = dbServiceClient;
    }

    @Override
    public boolean authenticate(String login, String password) {

        var client1 = dbServiceClient.findByLogin(login);
        return dbServiceClient.findByLogin(login)
                .map(client -> client.getPassword().equals(password))
                .orElse(false);
    }

}
