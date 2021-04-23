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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public String getZoomAccount() {
        return zoomAccount;
    }

    public void setZoomAccount(String zoomAccount) {
        this.zoomAccount = zoomAccount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
