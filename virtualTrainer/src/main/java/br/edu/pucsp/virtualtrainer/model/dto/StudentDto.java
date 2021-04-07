package br.edu.pucsp.virtualtrainer.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private String nickname;

    private String fullName;

    private LocalDate birthdate;

    private Long cpf;

    private String email;

    private Long cellphone;

    private String zoomAccount;

}
