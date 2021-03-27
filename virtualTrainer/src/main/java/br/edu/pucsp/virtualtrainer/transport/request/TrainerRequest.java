package br.edu.pucsp.virtualtrainer.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

@ApiModel(value = "TrainerRequest", description = "Transport class for Trainer")
public class TrainerRequest {

    @ApiModelProperty(name = "name")
    @NotEmpty(message = "The name cannot be null or empty")
    @Size(min = 3, max = 20, message = "A name should have between 3 and 20 characters")
    private String name;

    @ApiModelProperty(name = "surname")
    @NotEmpty(message = "The surname cannot be null or empty")
    @Size(min = 3, max = 100, message = "A surname should have between 3 and 100 characters")
    private String surname;

    @ApiModelProperty(name = "cpf")
    @Positive(message = "Invalid CPF number")
    //TODO create custom validator
    private Long cpf;

    @ApiModelProperty(name = "email")
    @Email(message = "This is not a valid email")
    private String email;

    @ApiModelProperty(name = "cellphone")
    @Positive(message = "Invalid cellphone number")
    //TODO create custom validator
    private Long cellphone;

    @ApiModelProperty(name = "whatsapp")
    @Positive(message = "Invalid whatsapp number")
    private Long whatsapp;

    @ApiModelProperty(name = "zoomAccount")
    @Email(message = "This is not a valid email")
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
