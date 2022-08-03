package com.credifamilia.crud.domain.exception;

public class ClientNotFound extends Exception{
    public ClientNotFound(String document) {
        super("Client with document number " + document + " was not found");
    }
}
