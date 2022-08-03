package com.credifamilia.crud.domain.exception;

public class InvalidClient extends Exception{
    public InvalidClient() {
        super("You tried to save and invalid client, please verify and try again.");
    }
}
