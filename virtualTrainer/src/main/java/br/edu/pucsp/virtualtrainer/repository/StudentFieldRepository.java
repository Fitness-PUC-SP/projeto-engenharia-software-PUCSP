package br.edu.pucsp.virtualtrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.pucsp.virtualtrainer.model.entity.StudentField;

public interface StudentFieldRepository extends JpaRepository<StudentField, Long> {
    
}

