package br.edu.pucsp.virtualtrainer.transport.request;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.edu.pucsp.virtualtrainer.validator.Cpf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StudentRequest", description = "Transport class for Student")
public class StudentRequest {

    @ApiModelProperty(name = "id")
    private Long id;

    @ApiModelProperty(name = "nickname")
    @NotEmpty(message = "The nickname cannot be null or empty")
    @Size(min = 3, max = 30, message = "A nickname should have between 3 and 20 characters")
    private String nickname;

    @ApiModelProperty(name = "fullName")
    @NotEmpty(message = "The full name cannot be null or empty")
    @Size(min = 3, max = 100, message = "A full name should have between 3 and 100 characters")
    private String fullName;

    //Data invalida
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
