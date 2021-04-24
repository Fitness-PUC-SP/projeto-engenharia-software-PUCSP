package br.edu.pucsp.virtualtrainer.service;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.model.entity.Student;
import br.edu.pucsp.virtualtrainer.repository.StudentRepository;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Captor
    ArgumentCaptor<Student> studentCaptor;
    
    @Mock
    StudentRepository repository;

    @InjectMocks
    StudentServiceImpl studentService;
   
    @Test
    public void whenCreatingStudent_shouldSave() {
        StudentRequest request = new StudentRequest();
        request.setFullName("Testing Student");

        studentService.createStudent(request);    
        verify(repository).save(studentCaptor.capture());

        Student created = studentCaptor.getValue();
        assertTrue(created.isActive());        
    }

    @Test
    public void whenSearchingStudentId_shouldFind(){
        Student student = new Student();
        student.setNickname("Student");
        
        when(repository.findById(1L)).thenReturn(of(student));
        
        StudentDto response = studentService.findStudent(1L);
        
        assertEquals("Student", response.getNickname());
    }

    @Test
    public void whenDeletingStudentById_shouldDelete(){
        Student student = new Student();

        when(repository.findById(1L)).thenReturn(of(student));

        studentService.deleteStudent(1L);
        verify(repository).save(studentCaptor.capture());

        Student deleted = studentCaptor.getValue();
        assertFalse(deleted.isActive()); 

    }

    @Test
    public void whenUpdatingStudentById_shouldUpdate(){
        StudentRequest request = new StudentRequest();
        request.setEmail("student_email@test.com");
        request.setZoomAccount("student_zoom@test.com");
        request.setCellphone(999999999L);

        Student student = new Student();
        when(repository.findById(1L)).thenReturn(of(student));
    

        studentService.updateStudent(request);
        verify(repository).save(studentCaptor.capture());
        Student updated = studentCaptor.getValue();
        
        assertEquals(request.getCellphone(), updated.getCellphone());
        assertEquals(request.getEmail(), updated.getEmail());
        assertEquals(request.getZoomAccount(), updated.getZoomAccount());

    }

    @Test
    (expected = DataNotFoundException.class)
    public void whenSearchingStudent_NotFindId_shouldThrowException(){
        when(repository.findById(1L)).thenReturn(empty());
        studentService.findStudent(1L);
    }

    @Test
    (expected = DataNotFoundException.class)
    public void whenDeletingStudent_NotFindId_shouldThrowException(){
        when(repository.findById(1L)).thenReturn(empty());
        studentService.deleteStudent(1L);
    }

    @Test
    (expected = DataNotFoundException.class)
    public void whenUpdatingStudent_NotFindId_shouldThrowException(){
        StudentRequest request = new StudentRequest();
        request.setFullName("Testing Student");

        when(repository.findById(1L)).thenReturn(empty());
        studentService.updateStudent(request);
    }
}

