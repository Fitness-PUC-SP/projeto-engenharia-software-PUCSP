package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.model.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query("SELECT count(s) > 0 FROM Session s WHERE lower(s.trainer) = lower(:trainerId) AND schedule = :date")
    boolean hasOverlappingClass(Long trainerId, Date date);

    Optional<List<Session>> findByStudent(Long studentId);

}
