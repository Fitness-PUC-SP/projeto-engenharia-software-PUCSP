package br.edu.pucsp.virtualTrainer.service;

import br.edu.pucsp.virtualTrainer.transport.request.TrainerRequest;
import br.edu.pucsp.virtualTrainer.transport.response.TrainerResponse;

public interface TrainerService {

    void createTrainer(TrainerRequest request);
    TrainerResponse findTrainer(String name);
    void addFields(String certificate);
}
