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

    @Column(nullable = false, length = 30)
    private String nickname;

    @Column(nullable = false, length = 60, name = "full_name")
    private String fullName;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false, unique = true)
    private Long cpf;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false)
    private Long cellphone;

    @Column(name = "zoom_account", length = 60)
    private String zoomAccount;

    @Column(nullable = false)
    private boolean active;

    public Student() {
        this.active = true;
    }
}
