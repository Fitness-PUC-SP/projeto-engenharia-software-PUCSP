package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.model.dto.FieldDto;
import br.edu.pucsp.virtualtrainer.model.entity.Field;
import org.mapstruct.Mapper;

@Mapper(uses = CategoryMapper.class)
public interface FieldMapper {

    FieldDto entityToDto(Field field);
}
