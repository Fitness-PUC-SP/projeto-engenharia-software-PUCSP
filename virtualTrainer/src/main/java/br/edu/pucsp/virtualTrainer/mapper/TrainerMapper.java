package br.edu.pucsp.virtualTrainer.mapper;

import br.edu.pucsp.virtualTrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualTrainer.model.entity.Trainer;
import br.edu.pucsp.virtualTrainer.transport.request.TrainerRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainerMapper {
    Trainer dtoToEntity(TrainerDto trainerDto);
    TrainerDto entityToDto(Trainer trainer);
    Trainer requestToEntity(TrainerRequest request) ;
}