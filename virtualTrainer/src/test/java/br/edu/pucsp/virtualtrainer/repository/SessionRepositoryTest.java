package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.model.entity.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

class SessionRepositoryTest extends AbstractRepositoryTest<SessionRepository, Session>{

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    FieldRepository fieldRepository;

    @Override
    protected Session buildEntity() {

        var session = new Session();
        session.setTrainer(trainerRepository.findAll().stream().findFirst().get());
        session.setField(fieldRepository.findAll().stream().findFirst().get());
        session.setSchedule(LocalDate.now());
        session.setLength(30);
        session.setConfirmed(true);
        return session;
    }

    @Test
    void testHasOverlappingClass(){
        Session session = buildEntity();

        repository.saveAndFlush(session);

        //boolean hasClass = repository.hasOverlappingClass(session.getTrainer().getId(), session.getSchedule());
        //Assertions.assertTrue(hasClass);
    }
}
