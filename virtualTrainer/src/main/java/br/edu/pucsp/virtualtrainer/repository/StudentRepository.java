package br.edu.pucsp.virtualtrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.pucsp.virtualtrainer.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.name = :name")
    Student findByName(String name);
    
    @Query("SELECT s FROM Student s WHERE s.id = :id")
    Student findOneStudent(Long id);
}
