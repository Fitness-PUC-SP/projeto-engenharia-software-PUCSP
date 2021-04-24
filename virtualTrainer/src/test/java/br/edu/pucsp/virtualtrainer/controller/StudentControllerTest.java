package br.edu.pucsp.virtualtrainer.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.service.StudentServiceImpl;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;

public class StudentControllerTest extends AbstractControllerTest {

    public static final String STUDENT_URL = "/student/";

    @MockBean
    private StudentServiceImpl studentService;

    private StudentRequest getStudentRequest() throws Exception {
        StudentRequest request = new StudentRequest();
        request.setNickname(NICKNAME);
        request.setFullName(FULL_NAME);
        request.setBirthDate(LocalDate.of(1995, 06, 03));
        request.setCpf(CPF);
        request.setCellphone(CELLPHONE);
        request.setEmail(EMAIL);
        request.setZoomAccount(EMAIL);
        return request;
    }

    private StudentDto getStudentDto() {
        StudentDto studentDto = new StudentDto();
        studentDto.setNickname(NICKNAME);
        studentDto.setFullName(FULL_NAME);
        studentDto.setCpf(CPF);
        studentDto.setBirthDate(LocalDate.of(1995, 06, 03));
        studentDto.setCellphone(CELLPHONE);
        studentDto.setEmail(EMAIL);
        studentDto.setZoomAccount(EMAIL);
        return studentDto;
    }

    private String getJson(StudentRequest request) throws Exception {
        OBJECT_MAPPER.registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String json = OBJECT_MAPPER.writeValueAsString(request);
        return json;
    }

    
    @Test
    public void whenPostingStudent_shouldGetCreated() throws Exception {
        StudentRequest request = getStudentRequest();
        String json = getJson(request);

        mvc.perform(post(STUDENT_URL).content(json).contentType(APPLICATION_JSON))
           .andExpect(status().isCreated());

    }

    @Test
    public void whenPostingStudent_shouldGetBadRequest_Email() throws Exception {
        StudentRequest request = getStudentRequest();
        request.setEmail(BAD_EMAIL);
        String json = getJson(request);

        mvc.perform(post(STUDENT_URL).content(json).contentType(APPLICATION_JSON))
           .andExpect(status().isBadRequest())
           .andExpect(jsonPath("$.message.email", is("This is not a valid email")));

    }

    @Test
    public void whenPostingStudent_shouldGetBadRequest_CPF() throws Exception {
        StudentRequest request = getStudentRequest();
        request.setCpf(BAD_CPF);
        String json = getJson(request);

        mvc.perform(post(STUDENT_URL).content(json).contentType(APPLICATION_JSON))
           .andExpect(status().isBadRequest())
           .andExpect(jsonPath("$.message.cpf", is("Invalid CPF number")));
    }

    @Test
    public void whenPostingStudent_shouldGetMethodNotAllowed() throws Exception {
        StudentRequest request = getStudentRequest();
        String json = getJson(request);

        mvc.perform(get(STUDENT_URL).content(json).contentType(APPLICATION_JSON))
           .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void whenUpdatingStudent_shouldGetOk() throws Exception {
        StudentRequest request = getStudentRequest();
        Long id = 1L;

        String json = getJson(request);
        mvc.perform(put(STUDENT_URL + id).content(json).contentType(APPLICATION_JSON))
           .andExpect(status().isOk());
    }

    @Test
    public void whenUpdatingStudent_shouldGetBadRequest() throws Exception {
        StudentRequest request = getStudentRequest();
        request.setEmail(BAD_EMAIL);

        Long id = 1L;

        String json = getJson(request);
        mvc.perform(put(STUDENT_URL + id).content(json).contentType(APPLICATION_JSON))
           .andExpect(status().isBadRequest());
    }

    @Test
    public void whenUpdatingStudent_shouldGetMethodNotAllowed() throws Exception {
        StudentRequest request = getStudentRequest();
        Long id = 1L;
        String json = getJson(request);

        mvc.perform(get(STUDENT_URL + id).content(json).contentType(APPLICATION_JSON))
           .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void whenUpdatingStudent_shouldGetNotFoundException() throws Exception {
        StudentRequest request = getStudentRequest();
        Long id = Long.MAX_VALUE;
        String json = getJson(request);

        doThrow(new DataNotFoundException(id)).when(studentService).updateStudent(any(StudentRequest.class), anyLong());

        mvc.perform(put(STUDENT_URL + id).content(json).contentType(APPLICATION_JSON))
           .andExpect(status().isNotFound());
    }

    @Test
    public void whenDeletingStudent_shouldGetOk() throws Exception{
        StudentRequest request = getStudentRequest();
        Long id = 1L;

        String json = getJson(request);
        mvc.perform(delete(STUDENT_URL + id).content(json).contentType(APPLICATION_JSON))
           .andExpect(status().isOk());
    }

    @Test
    public void whenDeletingStudent_shouldGetMethodNotAllowed() throws Exception{
        StudentRequest request = getStudentRequest();
        Long id = 1L;

        String json = getJson(request);
        mvc.perform(get(STUDENT_URL + id).content(json).contentType(APPLICATION_JSON))
           .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void whenReadingStudentById_shouldGetOk() throws Exception{
        Long id = 1L;

        StudentDto studentDto = getStudentDto();
        when(studentService.findStudent(1L)).thenReturn(studentDto);

        mvc.perform(get(STUDENT_URL + "id/" + id))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.student.nickname", is(studentDto.getNickname())))
           .andExpect(jsonPath("$.student.fullName", is(studentDto.getFullName())))
           .andExpect(jsonPath("$.student.cpf").isNumber())
           .andExpect(jsonPath("$.student.birthDate").isNotEmpty())
           .andExpect(jsonPath("$.student.email", is(studentDto.getEmail())))
           .andExpect(jsonPath("$.student.cellphone").isNumber())
           .andExpect(jsonPath("$.student.zoomAccount", is(studentDto.getZoomAccount())));
    }

    @Test
    public void whenReadingStudentByName_shouldGetOk() throws Exception{
        String name = "Student";

        StudentDto studentDto = getStudentDto();
        when(studentService.findStudents(name)).thenReturn(Arrays.asList(studentDto, studentDto));

        mvc.perform(get(STUDENT_URL + "name/" + name))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.students[0].nickname", is(studentDto.getNickname())))
           .andExpect(jsonPath("$.students[0].fullName", is(studentDto.getFullName())))
           .andExpect(jsonPath("$.students[0].cpf").isNumber())
           .andExpect(jsonPath("$.students[0].birthDate").isNotEmpty())
           .andExpect(jsonPath("$.students[0].email", is(studentDto.getEmail())))
           .andExpect(jsonPath("$.students[0].cellphone").isNumber())
           .andExpect(jsonPath("$.students[0].zoomAccount", is(studentDto.getZoomAccount())))
           .andExpect(jsonPath("$.students[1].nickname", is(studentDto.getNickname())))
           .andExpect(jsonPath("$.students[1].fullName", is(studentDto.getFullName())))
           .andExpect(jsonPath("$.students[1].cpf").isNumber())
           .andExpect(jsonPath("$.students[1].birthDate").isNotEmpty())
           .andExpect(jsonPath("$.students[1].email", is(studentDto.getEmail())))
           .andExpect(jsonPath("$.students[1].cellphone").isNumber())
           .andExpect(jsonPath("$.students[1].zoomAccount", is(studentDto.getZoomAccount())));
    }

//TODO incluir testes NotFindById (status http 404) para GET, DELETE e UPDATE
}
