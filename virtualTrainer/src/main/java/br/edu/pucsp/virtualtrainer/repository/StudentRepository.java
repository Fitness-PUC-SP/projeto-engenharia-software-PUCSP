package br.edu.pucsp.virtualtrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.pucsp.virtualtrainer.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
