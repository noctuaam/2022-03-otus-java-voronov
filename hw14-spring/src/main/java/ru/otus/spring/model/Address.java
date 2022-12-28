package ru.otus.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Aleksandr Voronov
 */
@Table(name = "address")
public class Address {

    @Id
    private final Long clientId;

    private final String street;

    @PersistenceCreator
    public Address(Long clientId, String street) {
        this.clientId = clientId;
        this.street = street;
    }

    public long getId() {
        return clientId;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "AddressDataSet{" +
                "clientId=" + clientId +
                ", street='" + street + '\'' +
                '}';
    }
}
