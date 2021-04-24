package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.service.StudentService;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import br.edu.pucsp.virtualtrainer.transport.response.StudentListResponse;
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
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody @Valid StudentRequest request) {
        studentService.createStudent(request);
    }

    @ApiOperation(value = "Find a Student from the database")
    @GetMapping(path = "/id/{studentId}")
    public StudentResponse getStudent(@PathVariable Long studentId) {
        return new StudentResponse(studentService.findStudent(studentId));
    }

    @ApiOperation(value = "Find a Student by name")
    @GetMapping(path = "/name/{studentName}")
    public StudentListResponse getStudents(@PathVariable String studentName){
        return new StudentListResponse(studentService.findStudents(studentName));
    }

    @ApiOperation(value = "Update a Student in the database")
    @PutMapping(path = "/{studentId}")
    public void updateStudent(@RequestBody @Valid StudentRequest request, @PathVariable Long id) {
        studentService.updateStudent(request, id);
    }

    @ApiOperation(value = "Delete (deactivate) a Student from the database")
    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}

