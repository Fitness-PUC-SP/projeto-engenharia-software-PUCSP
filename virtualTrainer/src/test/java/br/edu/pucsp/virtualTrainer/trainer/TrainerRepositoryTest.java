package br.edu.pucsp.virtualTrainer.trainer;

import br.edu.pucsp.virtualTrainer.model.entity.Trainer;
import br.edu.pucsp.virtualTrainer.repository.TrainerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

public class TrainerRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private TrainerRepository repository;

    @Test
    public void testSave(){
        int initialCount = repository.findAll().size();

        Trainer trainer = new Trainer();
        trainer.setName("Gob");
        repository.save(trainer);

        int finalCount = repository.findAll().size();

    }
}
