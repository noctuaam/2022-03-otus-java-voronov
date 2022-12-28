package ru.otus.hibernate.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * @author Aleksandr Voronov
 */
@Entity
@Table(name = "address")
public class Address implements Cloneable{

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    public Address() {
    }

    public Address(String street) {
        this.street = street;
    }

    public Address(Long id, String street) {

        if(id != null){
            this.id = id;
        }
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public Address clone() {
        return new Address(
                this.id,
                this.street
        );
    }

    @Override
    public String toString() {
        return "AddressDataSet{" +
                "id=" + id +
                ", street='" + street + '\'' +
                '}';
    }
}
