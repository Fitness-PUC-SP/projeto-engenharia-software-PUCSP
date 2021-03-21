package br.edu.pucsp.virtualTrainer.transport.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TrainerRequest {

    @NotEmpty(message = "A Name cannot be null or empty")
    @Size(min = 3, max = 20, message = "A name should have between 3 and 20 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
