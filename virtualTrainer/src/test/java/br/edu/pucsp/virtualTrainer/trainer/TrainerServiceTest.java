package br.edu.pucsp.virtualTrainer.trainer;

import br.edu.pucsp.virtualTrainer.model.entity.Trainer;
import br.edu.pucsp.virtualTrainer.repository.TrainerRepository;
import br.edu.pucsp.virtualTrainer.service.TrainerServiceImpl;
import br.edu.pucsp.virtualTrainer.transport.request.TrainerRequest;
import br.edu.pucsp.virtualTrainer.transport.response.TrainerResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TrainerServiceTest {

    @InjectMocks
    private TrainerServiceImpl fixture;

    @Mock
    private TrainerRepository repository;


    @Test
    public void testCreate(){
        TrainerRequest request = getTrainerRequest();
        fixture.createTrainer(request);
    }

    @Test
    public void testFind(){
        String name = "Astolfo";
        Trainer trainer = getTrainer(name);
        when(repository.findByName(anyString())).thenReturn(trainer);
        TrainerResponse response = fixture.findTrainer(name);
        Assertions.assertEquals(name, response.getTrainer().getName());
    }

    private TrainerRequest getTrainerRequest() {
        TrainerRequest request = new TrainerRequest();
        request.setName("Juao");
        return request;
    }

    private Trainer getTrainer(String name) {
        Trainer trainer = new Trainer();
        trainer.setName(name);
        trainer.setId(2L);
        return trainer;
    }
}
