package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.model.dto.CategoryDto;
import br.edu.pucsp.virtualtrainer.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    CategoryDto entityToDto(Category category);
}
