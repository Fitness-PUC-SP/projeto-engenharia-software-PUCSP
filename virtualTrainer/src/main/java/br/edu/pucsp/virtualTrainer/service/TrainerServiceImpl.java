package br.edu.pucsp.virtualTrainer.service;

import br.edu.pucsp.virtualTrainer.mapper.TrainerMapper;
import br.edu.pucsp.virtualTrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualTrainer.model.entity.Field;
import br.edu.pucsp.virtualTrainer.model.entity.Trainer;
import br.edu.pucsp.virtualTrainer.model.entity.TrainerField;
import br.edu.pucsp.virtualTrainer.repository.FieldRepository;
import br.edu.pucsp.virtualTrainer.repository.TrainerFieldRepository;
import br.edu.pucsp.virtualTrainer.repository.TrainerRepository;
import br.edu.pucsp.virtualTrainer.transport.request.TrainerRequest;
import br.edu.pucsp.virtualTrainer.transport.response.TrainerResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;


@Service
public class TrainerServiceImpl implements TrainerService {

    private static final TrainerMapper MAPPER = Mappers.getMapper(TrainerMapper.class);

    TrainerRepository repository;

    FieldRepository fieldRepository;

    TrainerFieldRepository trainerFieldRepository;

    public TrainerServiceImpl(TrainerRepository repository, FieldRepository fieldRepository,
                              TrainerFieldRepository trainerFieldRepository, TrainerFieldRepository trainerField2Repository){
        this.repository = repository;
        this.fieldRepository = fieldRepository;
        this.trainerFieldRepository = trainerFieldRepository;
    }

    @Override
    public void createTrainer(TrainerRequest request) {
        Trainer trainer = MAPPER.requestToEntity(request);
        repository.save(trainer);

    }

    public void addFields(String certificate){
        Field field = fieldRepository.getOne(1L);
        Trainer trainer = repository.getOne(1L);

        TrainerField trainerField = new TrainerField(trainer, field);
        trainerField.setCertificate(certificate);
        trainerFieldRepository.save(trainerField);
    }

    @Override
    public TrainerResponse findTrainer(String name) {
        Trainer trainer = repository.findByName(name);
        TrainerDto trainerDto = MAPPER.entityToDto(trainer);
        TrainerResponse response = new TrainerResponse();
        response.setTrainer(trainerDto);
        return response;
    }
}
