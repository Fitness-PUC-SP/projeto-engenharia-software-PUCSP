package br.edu.pucsp.virtualTrainer.service;

import br.edu.pucsp.virtualTrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualTrainer.model.entity.Trainer;
import br.edu.pucsp.virtualTrainer.repository.TrainerRepository;
import br.edu.pucsp.virtualTrainer.transport.request.TrainerRequest;
import br.edu.pucsp.virtualTrainer.transport.response.TrainerResponse;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {

    TrainerRepository repository;

    public TrainerServiceImpl(TrainerRepository repository){
        this.repository = repository;
    }

    @Override
    public void createTrainer(TrainerRequest request) {
        Trainer trainer = new Trainer();
        trainer.setName(request.getName());
        repository.save(trainer);
    }

    @Override
    public TrainerResponse findTrainer(String name) {
        Trainer trainer = repository.findByName(name);
        TrainerDto dto = new TrainerDto();
        dto.setName(trainer.getName());
        TrainerResponse response = new TrainerResponse();
        response.setTrainer(dto);
        return response;
    }
}
