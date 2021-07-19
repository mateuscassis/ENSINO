package br.edu.ifsp.domain.usecases.utils;

public class EntitieAlreadyExistException extends RuntimeException {
    public EntitieAlreadyExistException(String message) {
        super(message);
    }
}
