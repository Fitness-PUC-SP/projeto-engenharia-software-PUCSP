package br.edu.pucsp.virtualtrainer.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;

import br.edu.pucsp.virtualtrainer.model.entity.Student;

class StudentRepositoryTest extends AbstractRepositoryTest<StudentRepository, Student>{

    @Override
    protected Student buildEntity() {
        Student student = new Student();
        student.setNickname("Student");
        student.setFullName("Student Test");
        student.setCpf(50835322041L);
        student.setEmail("student@test.com");
        student.setBirthdate(LocalDate.EPOCH);
        student.setCellphone(11999998888L);
        return student;
    }

    
    @Test
    void whenCallRepositorySaveMethod_shouldSave(){
        int initialCount = repository.findAll().size();

        Student student = buildEntity();
        repository.save(student);

        int finalCount = repository.findAll().size();
        Assertions.assertNotEquals(initialCount, finalCount);
    }

    @Test
    void whenSavingMissingFields_shouldGetDataIntegrityViolationException(){
        Student student = buildEntity();
        student.setNickname(null);

        Assertions.assertThrows(DataIntegrityViolationException.class, () ->{
            repository.save(student);
        });
    }

    @Test
    void whenSavingDoubledCpf_shouldGetDataIntegrityViolationException(){
        Assertions.assertThrows(DataIntegrityViolationException.class, () ->{
            repository.saveAndFlush(buildEntity());
            repository.saveAndFlush(buildEntity());
        });
    }

    @Test
    void whenFindingById_shouldFind(){
        Student student = buildEntity();
        repository.save(student);

        Optional<Student> result = repository.findById(student.getId());
        Assertions.assertEquals(student.getNickname(), result.get().getNickname());
    }

    @Test
    void whenFindingById_shouldGetNoResult(){
        Optional<Student> result = repository.findById(Long.MAX_VALUE);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    void whenFindingByName_shouldFind(){
        Student student = buildEntity();
        repository.save(student);

        Optional<List<Student>> result = repository.findByNickname(student.getNickname());
        Assertions.assertEquals(student.getNickname(), result.get().stream().findFirst().get().getNickname());
    }
    
}
