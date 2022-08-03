package com.credifamilia.crud.infrastructure.persistence.mapper;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.credifamilia.crud.domain.Client;
import com.credifamilia.crud.infrastructure.dto.ClientDTO;
import com.credifamilia.crud.infrastructure.persistence.entity.ClientEntity;

public class ClientMapperImpl {

	public static Client toDomain(ClientEntity entity) {
		Client domain = new Client(entity.getDocumentNumber(), entity.getDocumentType(), entity.getFirstname(),
				entity.getLastname(), entity.getBirthday(), entity.getCity(), entity.getEmail(),
				entity.getPhoneNumber(), entity.getOccupation());
		domain.setViable(entity.getViable());
		return domain;
	}

	public static ClientEntity toEntity(Client domain) {
		ClientEntity entity = new ClientEntity();
		entity.setDocumentNumber(domain.getDocumentNumber());
		entity.setDocumentType(domain.getDocumentType());
		entity.setFirstname(domain.getFirstname());
		entity.setLastname(domain.getLastname());
		entity.setBirthday(domain.getBirthday());
		entity.setCity(domain.getCity());
		entity.setEmail(domain.getEmail());
		entity.setPhoneNumber(domain.getPhoneNumber());
		entity.setOccupation(domain.getOccupation());
		entity.setViable(domain.getViable());
		return entity;
	}

	public static List<Client> toDomainList(List<ClientEntity> entities) {
		List<Client> domains = new ArrayList<Client>();
		entities.forEach(entity -> domains.add(toDomain(entity)));
		return domains;
	}

	public static Client toDomain(ClientDTO dto) {
		return new Client(dto.getDocumentNumber(), dto.getDocumentType(), dto.getFirstname(), dto.getLastname(),
				dto.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), dto.getCity(),
				dto.getEmail(), dto.getPhoneNumber(), dto.getOccupation());
	}

	public static ClientDTO toDTO(Client domain) {
		return new ClientDTO(domain.getDocumentNumber(), domain.getDocumentType(), domain.getFirstname(),
				domain.getLastname(), Date.from(domain.getBirthday().atStartOfDay(ZoneId.systemDefault()).toInstant()),
				domain.getCity(), domain.getEmail(), domain.getPhoneNumber(), domain.getOccupation());
	}
	
	public static List<ClientDTO> toDTOs(List<Client> domains) {
		List<ClientDTO> dtos = new ArrayList<ClientDTO>();
		domains.forEach(domain -> dtos.add(toDTO(domain)));
		return dtos;
	}

}
