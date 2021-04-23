package br.edu.pucsp.virtualtrainer.transport.response;

import java.util.List;

import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;

public class StudentListResponse {
    private List<StudentDto> students;

    public StudentListResponse(List<StudentDto> students) {
        this.students = students;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }
}
