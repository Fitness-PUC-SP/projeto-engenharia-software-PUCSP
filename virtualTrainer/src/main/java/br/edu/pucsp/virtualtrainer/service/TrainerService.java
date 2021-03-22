package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import br.edu.pucsp.virtualtrainer.transport.response.TrainerResponse;

public interface TrainerService {

    void createTrainer(TrainerRequest request);
    TrainerResponse findTrainer(String name);
    void addFields(String certificate);
}
