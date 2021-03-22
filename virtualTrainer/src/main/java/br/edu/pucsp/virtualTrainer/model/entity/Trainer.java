package br.edu.pucsp.virtualTrainer.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Trainer {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Long cpf;

    @Column
    private String email;

    @Column
    private Long cellphone;

    @Column
    private Long whatsapp;

    @Column
    private String zoomAccount;

    @Column
    private boolean active;

    @OneToMany(mappedBy = "trainerId")
    private Set<TrainerField> fields;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public Long getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Long whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getZoomAccount() {
        return zoomAccount;
    }

    public void setZoomAccount(String zoomAccount) {
        this.zoomAccount = zoomAccount;
    }

    public Set<TrainerField> getFields() {
        return fields;
    }

    public void setFields(Set<TrainerField> fields) {
        this.fields = fields;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
