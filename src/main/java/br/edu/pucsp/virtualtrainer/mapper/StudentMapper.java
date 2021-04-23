package br.edu.pucsp.virtualtrainer.mapper;

import org.mapstruct.Mapper;

import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.model.entity.Student;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;

@Mapper()
public interface StudentMapper {
    Student dtoToEntity(StudentDto studentDto);
    StudentDto entityToDto(Student student);
    Student requestToEntity(StudentRequest request);
}