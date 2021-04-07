package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

class TrainerRepositoryTest extends AbstractRepositoryTest<TrainerRepository, Trainer> {

    @Test
    void testSave(){
        int initialCount = repository.findAll().size();

        Trainer trainer = buildEntity();
        repository.save(trainer);

        int finalCount = repository.findAll().size();
        Assertions.assertNotEquals(initialCount, finalCount);

    }

    @Test
    void testFind(){
        Trainer trainer = buildEntity();
        repository.save(trainer);

        Optional<List<Trainer>> result = repository.findByNickname(trainer.getNickname());
        Assertions.assertTrue(result.isPresent());
    }


    @Override
    protected Trainer buildEntity() {
        Trainer trainer = new Trainer();
        trainer.setNickname("Rick");
        trainer.setFullName("Ricky Martin");
        trainer.setEmail("Mail");
        trainer.setBirthdate(LocalDate.MIN);
        trainer.setCellphone(123L);
        return trainer;
    }
}
