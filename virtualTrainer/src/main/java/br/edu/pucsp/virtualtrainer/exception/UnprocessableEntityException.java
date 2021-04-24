package br.edu.pucsp.virtualtrainer.exception;

public class UnprocessableEntityException extends RuntimeException{

    public UnprocessableEntityException(String userType, Long id, String message){
        super(String.format("%s with id %d %s", userType, id, message));
    }
}
