package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import br.edu.pucsp.virtualtrainer.repository.TrainerRepository;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.*;
import static java.util.Optional.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class TrainerServiceTest {

    @InjectMocks
    private TrainerServiceImpl fixture;

    @Mock
    private TrainerRepository repository;


    @Test
    void testFindById(){
        String name = "Astolfo";
        Trainer trainer = getTrainer(name);
        when(repository.findById(1L)).thenReturn(of(trainer));
        TrainerDto response = fixture.findTrainer(1L);
        Assertions.assertEquals(name, response.getNickname());
    }

    @Test
    void testFindByIdNotFound(){
        when(repository.findById(1L)).thenReturn(empty());
        Assert.assertThrows(DataNotFoundException.class, () -> {
            fixture.findTrainer(1L);
        });
    }

    @Test
    void testFindByNameNotFound(){
        when(repository.findByNickname(anyString())).thenReturn(empty());

        Assert.assertThrows(DataNotFoundException.class, () -> {
            fixture.findTrainers("Some name");
        });
    }

    @Test
    void testFindByNameInactive(){
        Trainer trainer = getTrainer("Mark");
        trainer.setActive(false);
        when(repository.findByNickname(anyString())).thenReturn(of(singletonList(trainer)));

        List<TrainerDto> result = fixture.findTrainers("Some name");
        Assertions.assertTrue( result.isEmpty());
    }

    @Test
    void testFindByName(){
        when(repository.findByNickname(anyString())).thenReturn(of(singletonList(getTrainer("Mark"))));

        List<TrainerDto> result = fixture.findTrainers("Some name");
        Assertions.assertFalse( result.isEmpty());
    }

    @Test
    void testDelete(){
        ArgumentCaptor<Trainer> trainerCaptor = ArgumentCaptor.forClass(Trainer.class);

        when(repository.findById(anyLong())).thenReturn(of(getTrainer("Mark")));

        fixture.deleteTrainer(1L);

        verify(repository).save(trainerCaptor.capture());
        Trainer savedTrainer = trainerCaptor.getValue();
        Assertions.assertFalse(savedTrainer.isActive());
    }

    @Test
    void testDeleteNotFound(){
        when(repository.findById(1L)).thenReturn(empty());
        Assert.assertThrows(DataNotFoundException.class, () -> {
            fixture.deleteTrainer(1L);
        });
    }

    @Test
    void testUpdateNotFound(){
        TrainerRequest trainerRequest = getTrainerRequest();
        when(repository.findById(1L)).thenReturn(empty());
        Assert.assertThrows(DataNotFoundException.class, () -> {
            fixture.updateTrainer(trainerRequest, 1L);
        });
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
