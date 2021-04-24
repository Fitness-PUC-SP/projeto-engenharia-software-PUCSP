package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.repository.SessionRepository;
import br.edu.pucsp.virtualtrainer.transport.request.SessionRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
class SessionServiceTest {

    @InjectMocks
    private SessionServiceImpl fixture;

    @Mock
    private SessionRepository repository;

    @Test
    void test(){
        //Mockito.when(repository.hasOverlappingClass(anyLong(), any(LocalDate.class))).thenReturn(true);

        SessionRequest request = getresquest();
        Assert.assertThrows(DataNotFoundException.class, () -> {
            fixture.createSession(request);
        });
    }

    private SessionRequest getresquest() {
        SessionRequest request = new SessionRequest();
        request.setSchedule(LocalDate.now());
        request.setLength(30);
        request.setFieldId(1L);
        request.setTrainerId(1L);
        return request;

    }
}
