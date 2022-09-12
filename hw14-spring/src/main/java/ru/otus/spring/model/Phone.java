package ru.otus.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Aleksandr Voronov
 */
@Table(name = "phone")
public class Phone {

    @Id
    private final Long clientId;

    private final String number;

    @PersistenceCreator
    public Phone(Long clientId, String number) {
        this.clientId = clientId;
        this.number = number;
    }

    public Phone(String number) {
        this(null, number);
    }

    public long getClientId() {
        return clientId;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "PhoneDataSet{" +
                "clientId=" + clientId +
                ", number='" + number + '\'' +
                '}';
    }
}
