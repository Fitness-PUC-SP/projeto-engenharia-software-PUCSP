package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.service.StudentService;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import br.edu.pucsp.virtualtrainer.transport.request.StudentUpdateRequest;
import br.edu.pucsp.virtualtrainer.transport.response.StudentResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation(value = "Insert a Student into the database")
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes =APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody @Valid StudentRequest request) {
        studentService.createStudent(request);
    }

    @ApiOperation(value = "Find a Student from the database")
    @GetMapping(path = "/{studentId}")
    public StudentResponse getStudentById(@PathVariable Long studentId) {
        return new StudentResponse(studentService.findStudent(studentId));
    }

    @ApiOperation(value = "Update a Student in the database")
    @PutMapping(path = "")
    public void updateStudent(@RequestBody @Valid StudentUpdateRequest request) {
        studentService.updateStudent(request);
    }

    @ApiOperation(value = "Delete (deactivate) a Student from the database")
    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}

