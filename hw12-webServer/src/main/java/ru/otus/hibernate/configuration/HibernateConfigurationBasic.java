package ru.otus.hibernate.configuration;

import org.hibernate.cfg.Configuration;
import ru.otus.hibernate.dbmigrations.MigrationsExecutorFlyway;
import ru.otus.hibernate.model.Address;
import ru.otus.hibernate.model.Client;
import ru.otus.hibernate.model.Phone;
import ru.otus.hibernate.repository.DataTemplateHibernate;
import ru.otus.hibernate.repository.HibernateUtils;
import ru.otus.hibernate.service.DBServiceClient;
import ru.otus.hibernate.service.DbServiceClientImpl;
import ru.otus.hibernate.sessionmanager.TransactionManagerHibernate;

public class HibernateConfigurationBasic implements HibernateConfiguration {

    public static final String HIBERNATE_CONFIGURATION_LOCATION = "hibernate.cfg.xml";

    @Override
    public DBServiceClient configure() {
        var config = new Configuration().configure(HIBERNATE_CONFIGURATION_LOCATION);

        var url = config.getProperty("hibernate.connection.url");
        var userName = config.getProperty("hibernate.connection.username");
        var password = config.getProperty("hibernate.connection.password");

        MigrationsExecutorFlyway migrations = new MigrationsExecutorFlyway(url, userName, password);
        migrations.executeMigrations();

        var sessionFactory = HibernateUtils.buildSessionFactory(config, Client.class, Address.class, Phone.class);

        var transactionManager = new TransactionManagerHibernate(sessionFactory);
        var clientTemplate = new DataTemplateHibernate<>(Client.class);

        return new DbServiceClientImpl(transactionManager, clientTemplate);
    }
}
