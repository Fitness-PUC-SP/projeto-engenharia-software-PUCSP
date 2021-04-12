package br.edu.pucsp.virtualtrainer.transport.request;

import br.edu.pucsp.virtualtrainer.validator.Cpf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;
import java.time.LocalDate;

@ApiModel(value = "StudentRequest", description = "Transport class for Student")
public class StudentRequest {

    @ApiModelProperty(name = "nickname")
    @NotEmpty(message = "The nickname cannot be null or empty")
    @Size(min = 3, max = 30, message = "A nickname should have between 3 and 20 characters")
    private String nickname;

    @ApiModelProperty(name = "fullName")
    @NotEmpty(message = "The full name cannot be null or empty")
    @Size(min = 3, max = 100, message = "A full name should have between 3 and 100 characters")
    private String fullName;

    @ApiModelProperty(name = "birthdate")
    @Past(message = "This is not a valid date of birth")
    private LocalDate birthdate;

    @ApiModelProperty(name = "cpf")
    @Positive(message = "Invalid CPF number")
    @Cpf(message = "Invalid CPF number")
    private Long cpf;

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
