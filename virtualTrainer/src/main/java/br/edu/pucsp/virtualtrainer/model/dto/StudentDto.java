package br.edu.pucsp.virtualtrainer.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private String name;

    private String surname;

    private Long cpf;

    private String email;

    private Long cellphone;

    private Long whatsapp;

    private String zoomAccount;

}
