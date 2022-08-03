package com.credifamilia.crud.infrastructure.persistence.crud;

import com.credifamilia.crud.infrastructure.persistence.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<ClientEntity, String> {
}
