package br.edu.pucsp.virtualtrainer.trainer;

import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import br.edu.pucsp.virtualtrainer.repository.TrainerRepository;
import br.edu.pucsp.virtualtrainer.service.TrainerServiceImpl;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class TrainerServiceTest {

    @InjectMocks
    private TrainerServiceImpl fixture;

    @Mock
    private TrainerRepository repository;


    @Test
    void testCreate(){
        TrainerRequest request = getTrainerRequest();
        fixture.createTrainer(request);
    }

    @Test
    void testCreate2(){
        TrainerRequest request = getTrainerRequest();
        fixture.createTrainer(request);
    }

    @Test
    void testFind(){
        String name = "Astolfo";
        Trainer trainer = getTrainer(name);
        when(repository.findById(1L)).thenReturn(Optional.of(trainer));
        TrainerDto response = fixture.findTrainer(1L);
        Assertions.assertEquals(name, response.getNickname());
    }

    private TrainerRequest getTrainerRequest() {
        TrainerRequest request = new TrainerRequest();
        request.setNickname("Juao");
        return request;
    }

    private Trainer getTrainer(String name) {
        Trainer trainer = new Trainer();
        trainer.setNickname(name);
        trainer.setId(2L);
        return trainer;
    }
}
