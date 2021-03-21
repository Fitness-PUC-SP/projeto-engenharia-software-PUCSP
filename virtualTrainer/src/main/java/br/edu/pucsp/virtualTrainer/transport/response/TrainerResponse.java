package br.edu.pucsp.virtualTrainer.transport.response;

import br.edu.pucsp.virtualTrainer.model.dto.TrainerDto;

public class TrainerResponse {

    private TrainerDto trainer;

    public TrainerDto getTrainer() {
        return trainer;
    }

    public void setTrainer(TrainerDto trainer) {
        this.trainer = trainer;
    }
}
