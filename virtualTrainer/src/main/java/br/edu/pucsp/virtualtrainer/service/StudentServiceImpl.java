package br.edu.pucsp.virtualtrainer.service;

import java.security.InvalidParameterException;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import br.edu.pucsp.virtualtrainer.mapper.StudentMapper;
import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.model.entity.Student;
import br.edu.pucsp.virtualtrainer.repository.FieldRepository;
import br.edu.pucsp.virtualtrainer.repository.StudentFieldRepository;
import br.edu.pucsp.virtualtrainer.repository.StudentRepository;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import br.edu.pucsp.virtualtrainer.transport.response.StudentResponse;

@Service
public class StudentServiceImpl implements StudentService {

    private static final StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentRepository repository;

    FieldRepository fieldRepository;

    StudentFieldRepository studentFieldRepository;

    public StudentServiceImpl(StudentRepository repository, FieldRepository fieldRepository,
                              StudentFieldRepository studentFieldRepository){
        this.repository = repository;
        this.fieldRepository = fieldRepository;
        this.studentFieldRepository = studentFieldRepository;
    }

    @Override
    public void createStudent(StudentRequest request) {
        
        Student student;

        if(repository.findByName(request.getName()) == null){
            student = MAPPER.requestToEntity(request);
            student.setActive(true);
            repository.save(student);
        } else{
            throw new InvalidParameterException("This username already exists!");
        }
    }

    @Override
    public StudentResponse findStudent(String name) {
        Student student = repository.findByName(name);
        StudentDto studentDto = MAPPER.entityToDto(student);
        StudentResponse response = new StudentResponse();
        response.setStudent(studentDto);
        return response;
    }

    @Override
    public void deleteStudent(String name) {
    
        try {
            Student student = repository.findByName(name);
            repository.delete(student);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
