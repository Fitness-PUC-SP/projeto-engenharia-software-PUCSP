package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerUpdateRequest;

import java.util.List;

public interface TrainerService {

    void createTrainer(TrainerRequest request);
    List<TrainerDto> findTrainers(String name);
    TrainerDto findTrainer(Long trainerId);
    List<TrainerDto> findAllTrainers();
    void addFields(String certificate);
    void deleteTrainer(Long trainerId);
    void updateTrainer(TrainerUpdateRequest request);
}
