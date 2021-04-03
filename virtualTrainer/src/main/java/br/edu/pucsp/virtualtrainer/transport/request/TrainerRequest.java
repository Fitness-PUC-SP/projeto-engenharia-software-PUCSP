package br.edu.pucsp.virtualtrainer.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;
import java.time.LocalDate;

@ApiModel(value = "TrainerRequest", description = "Transport class for Trainer")
public class TrainerRequest {

    @ApiModelProperty(name = "nickname")
    @NotEmpty(message = "The nickname cannot be null or empty")
    @Size(min = 3, max = 30, message = "A nickname should have between 3 and 30 characters")
    private String nickname;

    @ApiModelProperty(name = "fullName")
    @NotEmpty(message = "The full name cannot be null or empty")
    @Size(min = 3, max = 60, message = "A full name should have between 3 and 60 characters")
    private String fullName;

    @ApiModelProperty(name = "cpf")
    @Positive(message = "Invalid CPF number")
    //TODO create custom validator
    private Long cpf;

    @ApiModelProperty(name = "cnpj")
    @Positive(message = "Invalid CNPJ number")
    //TODO create custom validator
    private Long cnpj;

    @ApiModelProperty(name = "birthdate")
    @Past(message = "This is not a valid date of birth")
    private LocalDate birthdate;

    @ApiModelProperty(name = "email")
    @Email(message = "This is not a valid email")
    private String email;

    @ApiModelProperty(name = "cellphone")
    @Positive(message = "Invalid cellphone number")
    //TODO create custom validator
    private Long cellphone;

    @ApiModelProperty(name = "zoomAccount")
    @Email(message = "This is not a valid email")
    private String zoomAccount;

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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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
}