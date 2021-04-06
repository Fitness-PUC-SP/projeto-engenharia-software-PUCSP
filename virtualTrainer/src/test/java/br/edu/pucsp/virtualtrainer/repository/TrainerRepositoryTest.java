package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

      /*  Trainer result = repository.findByName(trainer.getName());
        Assertions.assertEquals(trainer.getName(), result.getName());
    */}


    @Override
    protected Trainer buildEntity() {
        Trainer trainer = new Trainer();
        trainer.setNickname("Rick");
        trainer.setFullName("Ricky Martin");
        trainer.setEmail("Mail");
        return trainer;
    }
}
