package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import org.mapstruct.Mapper;

@Mapper()
public interface TrainerMapper {
    Trainer dtoToEntity(TrainerDto trainerDto);
    TrainerDto entityToDto(Trainer trainer);
    Trainer requestToEntity(TrainerRequest request) ;
}