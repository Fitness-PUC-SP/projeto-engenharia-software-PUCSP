package br.edu.pucsp.virtualTrainer.repository;

import br.edu.pucsp.virtualTrainer.model.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    @Query("SELECT t FROM Trainer t WHERE t.name = :name")
    Trainer findByName(String name);

}
