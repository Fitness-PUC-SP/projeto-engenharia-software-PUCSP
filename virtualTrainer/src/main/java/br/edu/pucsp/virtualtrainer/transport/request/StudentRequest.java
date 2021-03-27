package br.edu.pucsp.virtualtrainer.transport.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StudentRequest", description = "Transport class for Trainer")
public class StudentRequest {

    @ApiModelProperty(name = "name")
    @NotBlank(message = "A Name cannot be null or empty")
    @Size(min = 3, max = 20, message = "A name should have between 3 and 20 characters")
    private String name;

    private String surname;

    @NotNull(message = "The CPF cannot be null or empty")
    private Long cpf;

    @Email
    @NotBlank(message = "The email cannot be null or empty")
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
