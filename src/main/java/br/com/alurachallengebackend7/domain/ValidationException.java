package br.com.alurachallengebackend7.domain;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
