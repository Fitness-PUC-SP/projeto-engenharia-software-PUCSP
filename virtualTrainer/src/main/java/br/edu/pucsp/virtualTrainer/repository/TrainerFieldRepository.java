package br.edu.pucsp.virtualTrainer.repository;

import br.edu.pucsp.virtualTrainer.model.entity.TrainerField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerFieldRepository extends JpaRepository<TrainerField, Long> {
}
