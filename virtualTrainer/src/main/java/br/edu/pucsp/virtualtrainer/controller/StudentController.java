package br.edu.pucsp.virtualtrainer.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.pucsp.virtualtrainer.service.StudentService;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import br.edu.pucsp.virtualtrainer.transport.response.StudentResponse;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation(value = "Insert a Student into the database")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody @Valid StudentRequest request) {
        studentService.createStudent(request);
    }

    @ApiOperation(value = "Find a Student from the database")
    @GetMapping(path = "/{studentId}")
    public StudentResponse getStudent(@PathVariable Long studentId) {
        return new StudentResponse(studentService.findStudent(studentId));
    }

    @ApiOperation(value = "Update a Student in the database")
    @PutMapping(path = "/{studentId}")
    public void updateStudent(@RequestBody @Valid StudentRequest request, @PathVariable Long studentId) {
        studentService.updateStudent(request, studentId);
    }

    @ApiOperation(value = "Delete (deactivate) a Student from the database")
    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

}

