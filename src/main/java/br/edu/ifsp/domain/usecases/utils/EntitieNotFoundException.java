package br.edu.ifsp.domain.usecases.utils;

public class EntitieNotFoundException extends RuntimeException {
    public EntitieNotFoundException(String message) {
        super(message);
    }
}
