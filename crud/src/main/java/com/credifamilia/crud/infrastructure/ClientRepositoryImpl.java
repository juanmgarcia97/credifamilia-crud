package com.credifamilia.crud.infrastructure;

import com.credifamilia.crud.domain.Client;
import com.credifamilia.crud.infrastructure.persistence.crud.ClientCrudRepository;
import com.credifamilia.crud.infrastructure.persistence.entity.ClientEntity;
import com.credifamilia.crud.infrastructure.persistence.mapper.ClientMapperImpl;
import com.credifamilia.crud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Override
    public Client create(Client client) {
        ClientEntity entity = ClientMapperImpl.toEntity(client);
        return ClientMapperImpl.toDomain(clientCrudRepository.save(entity));
    }

    @Override
    public List<Client> findAll() {
        List<ClientEntity> entities = (List<ClientEntity>) clientCrudRepository.findAll();
        return ClientMapperImpl.toDomainList(entities);
    }

    @Override
    public Optional<Client> findByDocument(String documentNumber) {
        return clientCrudRepository.findById(documentNumber).map(client -> ClientMapperImpl.toDomain(client));
    }

    @Override
    public void delete(String documentNumber) {
        clientCrudRepository.deleteById(documentNumber);
    }
}
