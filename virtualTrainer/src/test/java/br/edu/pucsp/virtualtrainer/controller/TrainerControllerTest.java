package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.service.TrainerService;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import br.edu.pucsp.virtualtrainer.transport.response.TrainerResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TrainerControllerTest extends AbstractControllerTest {


    @Mock
    private TrainerService trainerService;


    @Test
    void testPostBadRequest() throws Exception {
        url = "/trainer";

        TrainerRequest request = getTrainerRequest();
        String jsonValue = OBJECT_MAPPER.writeValueAsString(request);

        mvc.perform(post(url)
                .content(jsonValue)
                .accept(APPLICATION_JSON_VALUE))
                .andExpect(status().isUnsupportedMediaType())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void testGet() throws Exception {
        url = "/trainer";
        String name = "Mark";

        TrainerResponse response = getTrainerResponse();

        when(trainerService.findTrainer(name)).thenReturn(response);

        mvc.perform(get(url + "/" + name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trainer.name", is("name")));
    }

    private TrainerRequest getTrainerRequest() {
        TrainerRequest request = new TrainerRequest();
        request.setName("Name");
        request.setSurname("Surname");
        request.setCpf(1234657890L);
        request.setCellphone(9999999L);
        request.setWhatsapp(9999999L);
        request.setEmail("mail");
        request.setZoomAccount("mail");
        return request;
    }

    private TrainerResponse getTrainerResponse() {
        TrainerResponse response = new TrainerResponse();
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setName("name");
        trainerDto.setSurname("surname");
        trainerDto.setCpf(13465790L);
        trainerDto.setCellphone(97987L);
        trainerDto.setWhatsapp(97987L);
        trainerDto.setEmail("mail");
        trainerDto.setZoomAccount("mail");
        response.setTrainer(trainerDto);
        return response;
    }
}
