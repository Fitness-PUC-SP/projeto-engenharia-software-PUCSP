package br.edu.pucsp.virtualtrainer.transport.response;

import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;

public class TrainerResponse {

    private TrainerDto trainer;

    public TrainerResponse(TrainerDto trainer) {
        this.trainer = trainer;
    }

    public TrainerDto getTrainer() {
        return trainer;
    }

    public void setTrainer(TrainerDto trainer) {
        this.trainer = trainer;
    }
}
