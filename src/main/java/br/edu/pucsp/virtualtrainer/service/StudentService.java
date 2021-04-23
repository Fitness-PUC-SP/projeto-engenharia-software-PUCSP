package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;

public interface StudentService {

    void createStudent(StudentRequest request);
    StudentDto findStudent(Long id);
    void deleteStudent(Long id);
    void updateStudent(StudentRequest request, Long id);
}