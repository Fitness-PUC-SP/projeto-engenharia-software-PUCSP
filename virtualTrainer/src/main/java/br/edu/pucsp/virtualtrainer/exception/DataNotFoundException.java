package br.edu.pucsp.virtualtrainer.exception;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String id){
        super(String.format("Entity with Id %s not found", id));
    }
}