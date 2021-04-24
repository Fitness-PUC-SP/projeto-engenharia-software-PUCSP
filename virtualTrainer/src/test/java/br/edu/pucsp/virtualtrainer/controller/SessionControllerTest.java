package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.service.SessionServiceImpl;
import br.edu.pucsp.virtualtrainer.transport.request.SessionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SessionControllerTest extends AbstractControllerTest {


    @MockBean
    private SessionServiceImpl sessionService;

    @Test
    void testPost() throws Exception {
        url = "/session";

        mvc.perform(post(url)
                .content(getJson(getSessionRequest()))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    public SessionRequest getSessionRequest() {
        var request = new SessionRequest();
        request.setSchedule(LocalDate.of(2021, 6, 12));
        request.setTrainerId(2L);
        request.setStudentId(3L);
        request.setFieldId(4L);
        request.setLength(34);
        return request;
    }
}
