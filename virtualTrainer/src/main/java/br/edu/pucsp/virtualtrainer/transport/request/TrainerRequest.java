package br.edu.pucsp.virtualtrainer.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(value = "TrainerRequest", description = "Transport class for Trainer")
public class TrainerRequest {

    @ApiModelProperty(name = "name")
    @NotEmpty(message = "A Name cannot be null or empty")
    @Size(min = 3, max = 20, message = "A name should have between 3 and 20 characters")
    private String name;

    private String surname;

    private Long cpf;

    private String email;

    private Long cellphone;

    private Long whatsapp;

    private String zoomAccount;

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
}
