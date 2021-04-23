package br.edu.pucsp.virtualtrainer.transport.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

public class StudentUpdateRequest {

    @ApiModelProperty(name = "id")
    private Long id;

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
