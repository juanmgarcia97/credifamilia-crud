package com.credifamilia.crud.service;

import com.credifamilia.crud.domain.Client;
import com.credifamilia.crud.domain.exception.ClientAlreadyExists;
import com.credifamilia.crud.domain.exception.ClientNotFound;
import com.credifamilia.crud.domain.exception.EmptyClients;

import java.util.List;

public interface ClientService {
    List<Client> findAll() throws EmptyClients;
    Client create(Client client) throws ClientAlreadyExists;
    Client findByDocument(String document) throws ClientNotFound;
    void delete(String document) throws ClientNotFound;
}
