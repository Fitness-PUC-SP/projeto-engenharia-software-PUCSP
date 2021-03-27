package br.edu.pucsp.virtualtrainer.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.pucsp.virtualtrainer.service.StudentService;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import br.edu.pucsp.virtualtrainer.transport.response.StudentResponse;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @ApiOperation(value = "Insert a Student into the database")
    @PostMapping()
    public void createStudent(@RequestBody @Valid StudentRequest request){
        studentService.createStudent(request);
    }

    @GetMapping(path = "/{studentName}")
    @ResponseBody
    public StudentResponse getStudent(@PathVariable String studentName){
        return studentService.findStudent(studentName);
    }

    @ApiOperation(value = "Delete a Student from the database")
    @DeleteMapping(path = "/{studentName}")
    @ResponseBody
    public void deleteStudent(@PathVariable String studentName){
        studentService.deleteStudent(studentName);
    }
}

