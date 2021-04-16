package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;

import java.sql.SQLIntegrityConstraintViolationException;
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
    void testSaveMissingFields(){
        Trainer trainer = buildEntity();
        trainer.setNickname(null);

        Assertions.assertThrows(DataIntegrityViolationException.class, () ->{
            repository.save(trainer);
        });
    }

    @Test
    void testSaveDoubledCpf(){//nao da erro
        Assertions.assertThrows(SQLIntegrityConstraintViolationException.class, () ->{
            repository.saveAndFlush(buildEntity());
            repository.saveAndFlush(buildEntity());
        });
    }

    @Test
    void testFindById(){
        Trainer trainer = buildEntity();
        repository.save(trainer);

        Optional<Trainer> result = repository.findById(trainer.getId());
        Assertions.assertEquals(trainer.getNickname(), result.get().getNickname());
    }

    @Test
    void testFindByIdNoResult(){
        Optional<Trainer> result = repository.findById(Long.MAX_VALUE);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    void testFindByName(){
        Trainer trainer = buildEntity();
        repository.save(trainer);

        Optional<List<Trainer>> result = repository.findByNickname(trainer.getNickname());
        Assertions.assertEquals(trainer.getNickname(), result.get().stream().findFirst().get().getNickname());
    }

    @Override
    protected Trainer buildEntity() {
        Trainer trainer = new Trainer();
        trainer.setNickname("Ricky");
        trainer.setFullName("Martin");
        trainer.setEmail("Mail");
        trainer.setBirthdate(LocalDate.now());
        trainer.setCellphone(1234L);
        return trainer;
    }
}
