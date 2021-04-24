package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.exception.UnprocessableEntityException;
import br.edu.pucsp.virtualtrainer.mapper.SessionMapper;
import br.edu.pucsp.virtualtrainer.model.entity.Session;
import br.edu.pucsp.virtualtrainer.repository.SessionRepository;
import br.edu.pucsp.virtualtrainer.transport.request.SessionRequest;
import br.edu.pucsp.virtualtrainer.transport.response.SessionResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionServiceImpl implements SessionService {

    private static final SessionMapper MAPPER = Mappers.getMapper(SessionMapper.class);

    private final SessionRepository repository;

    private final StudentService studentService;

    private final TrainerService trainerService;

    public SessionServiceImpl(SessionRepository repository, StudentService studentService,
                              TrainerService trainerService){
        this.repository = repository;
        this.studentService = studentService;
        this.trainerService = trainerService;
    }

    @Override
    public void createSession(SessionRequest request){
        var session = MAPPER.requestToEntity(request);
        hasClass(request);
        checkForZoomAccounts(request);
        repository.save(session);
    }

    @Override
    public void updateSession(SessionRequest request) {

    }

    @Override
    public SessionResponse getSessions(Long studentId) {
        List<Session> sessions = repository.findByStudent(studentId)
                .orElseThrow(() -> new DataNotFoundException(studentId));
        var sessionDtoList = sessions
                .stream()
                .map(MAPPER::entityToDto)
                .collect(Collectors.toList());

        var sessionResponse = new SessionResponse();
        sessionResponse.setSessions(sessionDtoList);

        return sessionResponse;
    }



    private void checkForZoomAccounts(SessionRequest request) {
        if(!studentService.hasZoomAccount(request.getStudentId())){
            throw new UnprocessableEntityException("Student", request.getStudentId(), "does not have an account");
        }
        if(!trainerService.hasZoomAccount(request.getTrainerId())){
            throw new UnprocessableEntityException("Trainer", request.getTrainerId(), "does not have an account");
        }
    }


    private void hasClass(SessionRequest request) {
        Date date = Date.from(request.getSchedule().atStartOfDay(ZoneId.systemDefault()).toInstant());
        //var hasResults = repository.hasOverlappingClass(request.getTrainerId(), request.getSchedule());
        var hasResults = repository.hasOverlappingClass(request.getTrainerId(), date);
        if(hasResults){
            throw new UnprocessableEntityException("Trainer", request.getTrainerId(), "already has a class for this period");
        }
    }

}
