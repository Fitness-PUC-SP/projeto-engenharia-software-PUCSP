package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    @Query("SELECT t FROM Trainer t WHERE lower(t.nickname) like lower(:nickname)")
    Optional<List<Trainer>> findByNickname(String nickname);

    @Query("SELECT count(t) > 0 FROM Trainer t WHERE t.id = :trainerId AND t.zoomAccount IS NOT NULL")
    boolean hasZoomAccount(Long trainerId);

}
