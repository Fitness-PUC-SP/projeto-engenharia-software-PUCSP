package br.edu.pucsp.virtualtrainer.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.mapper.StudentMapper;
import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.model.entity.Student;
import br.edu.pucsp.virtualtrainer.repository.StudentRepository;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import br.edu.pucsp.virtualtrainer.transport.request.StudentUpdateRequest;

@Service
public class StudentServiceImpl implements StudentService {

    private static final StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createStudent(StudentRequest request) {
        Student student = MAPPER.requestToEntity(request);
        repository.save(student);

    }

    @Override
    public StudentDto findStudent(Long id) {
        Student student = repository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
        return MAPPER.entityToDto(student);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = repository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
        student.setActive(false);
        repository.save(student);
    }

    @Override
    public void updateStudent(StudentUpdateRequest request) {
        Student student = repository.findById(request.getId()).orElseThrow(() -> new DataNotFoundException(request.getId()));
        student.setEmail(request.getEmail());
        student.setZoomAccount(request.getZoomAccount());
        student.setCellphone(request.getCellphone());
        repository.save(student);
    }
}
