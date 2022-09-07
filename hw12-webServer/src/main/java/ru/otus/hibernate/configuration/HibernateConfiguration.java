package ru.otus.hibernate.configuration;

import ru.otus.hibernate.service.DBServiceClient;

public interface HibernateConfiguration {
    DBServiceClient configure();
}
