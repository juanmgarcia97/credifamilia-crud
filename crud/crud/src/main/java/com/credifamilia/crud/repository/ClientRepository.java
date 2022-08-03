package com.credifamilia.crud.repository;

import com.credifamilia.crud.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Client create(Client client);
    List<Client> findAll();
    Optional<Client> findByDocument(String documentNumber);
    void delete(String documentNumber);
}
