package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import br.edu.pucsp.virtualtrainer.transport.response.StudentResponse;

public interface StudentService {

    void createStudent(StudentRequest request);
    StudentResponse findStudent(String name);
    void deleteStudent(String name);

}

// verificar se faz sentido trocar o name pra id, porque existem pessoas com mesmo nome ou garantir que nunca
// serão criados nomes iguais (username)