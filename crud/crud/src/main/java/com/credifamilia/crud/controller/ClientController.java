package com.credifamilia.crud.controller;

import com.credifamilia.crud.domain.Client;
import com.credifamilia.crud.domain.exception.ClientAlreadyExists;
import com.credifamilia.crud.domain.exception.ClientNotFound;
import com.credifamilia.crud.domain.exception.EmptyClients;
import com.credifamilia.crud.infrastructure.dto.ClientDTO;
import com.credifamilia.crud.infrastructure.persistence.mapper.ClientMapperImpl;
import com.credifamilia.crud.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;


	@GetMapping("/")
	public ResponseEntity<ResponseBody<List<Client>>> findAll() {
		try {
			List<Client> clients = clientService.findAll();
			return ResponseEntity.ok(new ResponseBody<List<Client>>("Clients found", clients, HttpStatus.OK.value()));
		} catch (EmptyClients e) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseBody<>("There are no clients", null, HttpStatus.OK.value()));
		}
	}

	@PostMapping("/")
	public ResponseEntity<ResponseBody<Client>> create(@Valid @RequestBody Client client, BindingResult bindingResult) {
		if(bindingResult.hasErrors() || bindingResult.hasFieldErrors()) {
			return  ResponseEntity.badRequest()
					.body(new ResponseBody<Client>("Client cannot be invalid, please verify.", client, HttpStatus.BAD_REQUEST.value()));
		}
		try {			
			Client newClient = clientService.create(client);
			return ResponseEntity.created(null).body(new ResponseBody<Client>("Client created successfully",
					newClient, HttpStatus.CREATED.value()));
		} catch (ClientAlreadyExists e) {
			return  ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new ResponseBody<Client>("Client already exists.", client, HttpStatus.CONFLICT.value()));
		}
	}

	@GetMapping("/{document}")
	public ResponseEntity<ResponseBody<Client>> findByDocument(@PathVariable("document") String document) {
		try {
			Client client = clientService.findByDocument(document);
			return ResponseEntity.ok().body(new ResponseBody<Client>("Client with document " + document + " founded.",
					client, HttpStatus.OK.value()));
		} catch (ClientNotFound e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseBody<Client>(
					"Client with document " + document + " not found.", null, HttpStatus.NOT_FOUND.value()));
		}
	}

	@DeleteMapping("/{document}")
	public ResponseEntity<ResponseBody<Boolean>> delete(@PathVariable("document") String document) {
		try {
			clientService.delete(document);
			return ResponseEntity.ok(new ResponseBody<Boolean>(
					"Client with document " + document + "deleted successfully.", null, HttpStatus.OK.value()));
		} catch (ClientNotFound e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseBody<Boolean>("Client not found", null, HttpStatus.NOT_FOUND.value()));
		}
	}

}
