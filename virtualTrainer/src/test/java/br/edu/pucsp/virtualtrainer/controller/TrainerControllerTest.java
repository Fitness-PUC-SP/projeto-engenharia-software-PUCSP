package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.service.TrainerServiceImpl;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TrainerControllerTest extends AbstractControllerTest {

    @MockBean
    private TrainerServiceImpl trainerService;


    @Test
    void testPostIsBadRequest() throws Exception {
        url = "/trainer";

        TrainerRequest request = getTrainerRequest();
        request.setEmail(BAD_EMAIL);
        String jsonValue = OBJECT_MAPPER.writeValueAsString(request);

        mvc.perform(post(url)
                .content(jsonValue)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void testPostBadCpf() throws Exception {
        url = "/trainer";

        TrainerRequest request = getTrainerRequest();
        request.setCpf(BAD_CPF);
        String jsonValue = OBJECT_MAPPER.writeValueAsString(request);

        mvc.perform(post(url)
                .content(jsonValue)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message.cpf", is("Invalid CPF number")))
                .andDo(print());
    }@Test
    void testPostBadCnpj() throws Exception {
        url = "/trainer";

        TrainerRequest request = getTrainerRequest();
        request.setCnpj(BAD_CNPJ);
        String jsonValue = OBJECT_MAPPER.writeValueAsString(request);

        mvc.perform(post(url)
                .content(jsonValue)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message.cnpj", is("Invalid CNPJ number")))
                .andDo(print());
    }

    @Test
    void testPost() throws Exception {
        url = "/trainer";

        TrainerRequest request = getTrainerRequest();
        String jsonValue = OBJECT_MAPPER.writeValueAsString(request);

        mvc.perform(post(url)
                .content(jsonValue)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void testGetTrainerByName() throws Exception {
        url = "/trainer/name/";
        String name = "Bob";

        when(trainerService.findTrainers(name)).thenReturn(Collections.singletonList(getTrainerDto()));

        mvc.perform(get(url + name))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    void testGetTrainerByNameIsNotAllowed() throws Exception {
        url = "/trainer/name/";

        mvc.perform(get(url ))
                .andExpect(status().isMethodNotAllowed())
                .andDo(print());
    }


    @Test
    void testGetById() throws Exception {
        url = "/trainer/id/";
        long id = 1L;

        TrainerDto trainerDto = getTrainerDto();
        when(trainerService.findTrainer(anyLong())).thenReturn(trainerDto);

        mvc.perform(get(url + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trainer.nickname", is(trainerDto.getNickname())))
                .andExpect(jsonPath("$.trainer.fullName", is(trainerDto.getFullName())))
                .andExpect(jsonPath("$.trainer.cpf").isNumber())
                .andExpect(jsonPath("$.trainer.cnpj").doesNotExist())
                .andExpect(jsonPath("$.trainer.birthDate").isNotEmpty())
                .andExpect(jsonPath("$.trainer.email", is(trainerDto.getEmail())))
                .andExpect(jsonPath("$.trainer.cellphone").isNumber())
                .andExpect(jsonPath("$.trainer.zoomAccount", is(trainerDto.getZoomAccount())))
                .andExpect(jsonPath("$.trainer.active", is(trainerDto.isActive())))
                .andDo(print());
    }

    @Test
    void testGetByIdIsNotAllowed() throws Exception {
        url = "/trainer/id/";

        TrainerDto trainerDto = getTrainerDto();
        when(trainerService.findTrainer(anyLong())).thenReturn(trainerDto);

        mvc.perform(get(url))
                .andExpect(status().isMethodNotAllowed())
                .andDo(print());
    }

    @Test
    void testGetAll() throws Exception {
        url = "/trainer";

        TrainerDto trainerDto = getTrainerDto();
        when(trainerService.findAllTrainers()).thenReturn(Arrays.asList(trainerDto, trainerDto));

        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trainers.[0]").isNotEmpty())
                .andExpect(jsonPath("$.trainers.[1]").isNotEmpty())
                .andDo(print());
    }

    @Test
    void testUpdate() throws Exception {
        url = "/trainer/";
        long id = 1L;

        TrainerRequest request = getTrainerRequest();
        String jsonValue = OBJECT_MAPPER.writeValueAsString(request);

        mvc.perform(put(url + id)
                .content(jsonValue)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testUpdateIsNotAllowed() throws Exception {
        url = "/trainer/";

        mvc.perform(put(url)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed())
                .andDo(print());
    }

    @Test
    void testUpdateIsBadRequest() throws Exception {
        url = "/trainer/";
        long id = 1L;

        TrainerRequest request = getTrainerRequest();
        request.setCpf(BAD_CPF);
        String jsonValue = OBJECT_MAPPER.writeValueAsString(request);

        mvc.perform(put(url + id)
                .content(jsonValue)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message.cpf", is("Invalid CPF number")))
                .andDo(print());
    }

    @Test
    void testDelete() throws Exception{
        url = "/trainer/";
        long id = 1L;

        mvc.perform(delete(url + id))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testDeleteIsNotAllowed() throws Exception{
        url = "/trainer/";

        mvc.perform(delete(url))
                .andExpect(status().isMethodNotAllowed())
                .andDo(print());
    }

    public TrainerRequest getTrainerRequest() {
        TrainerRequest request = new TrainerRequest();
        request.setNickname(NICKNAME);
        request.setFullName(FULL_NAME);
        request.setBirthdate(LocalDate.parse("2020-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        request.setCpf(CPF);
        request.setCnpj(CNPJ);
        request.setCellphone(CELLPHONE);
        request.setEmail(EMAIL);
        request.setZoomAccount(EMAIL);
        return request;
    }

    private TrainerDto getTrainerDto() {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setNickname(NICKNAME);
        trainerDto.setFullName(FULL_NAME);
        trainerDto.setCpf(CPF);
        trainerDto.setBirthDate(LocalDate.MIN);
        trainerDto.setCellphone(CELLPHONE);
        trainerDto.setEmail(EMAIL);
        trainerDto.setZoomAccount(EMAIL);
        return trainerDto;
    }
}
