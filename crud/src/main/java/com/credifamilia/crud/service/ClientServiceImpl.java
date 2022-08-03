package com.credifamilia.crud.service;

import com.credifamilia.crud.domain.Client;
import com.credifamilia.crud.domain.exception.ClientAlreadyExists;
import com.credifamilia.crud.domain.exception.ClientNotFound;
import com.credifamilia.crud.domain.exception.EmptyClients;
import com.credifamilia.crud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() throws EmptyClients {
        List<Client> clients = clientRepository.findAll();
        if(clients.size() == 0) throw new EmptyClients();
        return clients;
    }

    @Override
    public Client create(Client client) throws ClientAlreadyExists {
    	Client exists = null;
    	try {
    		exists = findByDocument(client.getDocumentNumber());
    	} catch(ClientNotFound e) {
			
		}
    	if(exists != null) throw new ClientAlreadyExists();
    	return clientRepository.create(client);
    }

    @Override
    public Client findByDocument(String document) throws ClientNotFound {
        Optional<Client> client = clientRepository.findByDocument(document);
        if(client.isEmpty()) throw new ClientNotFound(document);
        return client.get();
    }

    @Override
    public void delete(String document) throws ClientNotFound {
        findByDocument(document);
        clientRepository.delete(document);
    }
}
