package ru.otus.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.spring.model.Client;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findAll();
}
