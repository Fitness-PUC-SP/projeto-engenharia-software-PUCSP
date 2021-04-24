package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.model.dto.SessionDto;
import br.edu.pucsp.virtualtrainer.model.entity.Session;
import br.edu.pucsp.virtualtrainer.transport.request.SessionRequest;
import org.mapstruct.Mapper;

@Mapper(uses = TrainerMapper.class)
public interface SessionMapper {

    SessionDto entityToDto(Session session);
    Session requestToEntity(SessionRequest request);



}
