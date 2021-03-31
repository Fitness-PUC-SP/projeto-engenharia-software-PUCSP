package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    @Query("SELECT t FROM Trainer t WHERE lower(t.name) like lower(:name) AND lower(t.surname) like lower(:surname)")
    Optional<List<Trainer>> findByFullName(String name, String surname);

}
