package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import br.edu.pucsp.virtualtrainer.transport.response.StudentResponse;

public interface StudentService {

    void createStudent(StudentRequest request);
    StudentResponse findStudent(Long id);
    void deleteStudent(Long id);

}
