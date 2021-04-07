package br.edu.pucsp.virtualtrainer.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickname;

    @Column
    private String fullName;

    @Column
    private LocalDate birthdate;

    @Column
    private Long cpf;

    @Column
    private String email;

    @Column
    private Long cellphone;

    @Column
    private String zoomAccount;

    @Column
    private boolean active;

    public Student() {
        this.active = true;
    }
}
