package br.edu.pucsp.virtualtrainer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.pucsp.virtualtrainer.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE lower(s.nickname) like lower(:nickname)")
    Optional<List<Student>> findByNickname(String nickname);

}
