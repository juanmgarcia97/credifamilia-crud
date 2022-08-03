package com.credifamilia.crud.domain.exception;

public class EmptyClients extends Exception{
    public EmptyClients() {
        super("There is no clients to show");
    }
}
