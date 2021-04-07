package br.edu.pucsp.virtualtrainer.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Trainer {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nickname;

    @Column(name = "full_name", nullable = false, length = 60)
    private String fullName;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(unique = true)
    private Long cpf;

    @Column(unique = true)
    private Long cnpj;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false)
    private Long cellphone;

    @Column(name = "zoom_account", length = 60)
    private String zoomAccount;

    @Column(nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "trainerId")
    private Set<TrainerField> fields;

    public Trainer() {
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

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
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
