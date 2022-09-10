package ru.otus;

import ru.otus.hibernate.configuration.HibernateConfiguration;
import ru.otus.hibernate.configuration.HibernateConfigurationBasic;
import ru.otus.hibernate.configuration.ServerConfigurationBasic;
import ru.otus.hibernate.model.Client;


/*
    Полезные для демо ссылки

    // Стартовая страница
    http://localhost:8080

    // Страница клиентов
    http://localhost:8080/clients

*/
public class WebServerWithFilterBasedSecurityDemo {

    public static void main(String[] args) throws Exception {
        HibernateConfiguration hibernateConfiguration = new HibernateConfigurationBasic();

        var dbServiceClient = hibernateConfiguration.configure();

        var client1 = new Client("admin","user1", "11111");
        var client2 = new Client("Ivan","user2", "22222");
        var client3 = new Client("Vlad","user3", "33333");
        var client4 = new Client("Alexandr","user4", "44444");
        var savedClient1 = dbServiceClient.saveClient(client1);
        var savedClient2 = dbServiceClient.saveClient(client2);
        var savedClient3 = dbServiceClient.saveClient(client3);
        var savedClient4 = dbServiceClient.saveClient(client4);

        var webServerConfiguration = new ServerConfigurationBasic(dbServiceClient);
        var webServer = webServerConfiguration.configure();

        webServer.start();
        webServer.join();
    }
}
