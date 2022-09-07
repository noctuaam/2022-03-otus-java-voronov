package ru.otus.hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "client")
public class Client implements Cloneable {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "client", orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    public Client() {
    }

    public Client(String name,String login, String password) {
        this.id = null;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Client(Long id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Client(Long id, String name, String login, String password, Address address, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phones = phones;
        this.login = login;
        this.password = password;

        if (phones != null) {
            for (Phone p : phones) {
                p.setClient(this);
            }
        }
    }

    @Override
    public Client clone() {
        Address addressCopy = this.address != null ? this.address.clone() : null;
        List<Phone> phonesCopy = phones != null ? List.copyOf(this.phones) : null;

        return new Client(
                this.id,
                this.name,
                this.login,
                this.password,
                addressCopy,
                phonesCopy
        );
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(Phone phone) {
        this.phones.add(phone);
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void removePhone(Phone phone) {
        this.phones.remove(phone);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", address=" + address +
                ", phones=" + phones +
                '}';
    }
}


