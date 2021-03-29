package br.edu.pucsp.virtualtrainer.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import br.edu.pucsp.virtualtrainer.mapper.StudentMapper;
import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.model.entity.Student;
import br.edu.pucsp.virtualtrainer.repository.StudentRepository;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import br.edu.pucsp.virtualtrainer.transport.response.StudentResponse;

@Service
public class StudentServiceImpl implements StudentService {

    private static final StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository){
        this.repository = repository;
    }

    @Override
    public void createStudent(StudentRequest request) {
        Student student = MAPPER.requestToEntity(request);
        student.setActive(true);
        repository.save(student);
        
    }

    @Override
    public StudentResponse findStudent(Long id) {
        Student student = repository.findOneStudent(id);
        StudentDto studentDto = MAPPER.entityToDto(student);
        StudentResponse response = new StudentResponse();
        response.setStudent(studentDto);
        return response;
    }

    @Override
    public void deleteStudent(Long id) {
    
        try {
            repository.deleteById(id);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
