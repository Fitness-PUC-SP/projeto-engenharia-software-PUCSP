package br.edu.pucsp.virtualtrainer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractControllerTest{

    public static final String NICKNAME = "nickname";
    public static final String FULL_NAME = "full name";
    public static final long CPF = 39794234095L;
    public static final long BAD_CPF = 1234567892L;
    public static final long CNPJ = 52063444000170L;
    public static final long BAD_CNPJ = 52063444000171L;
    public static final long CELLPHONE = 9999999L;
    public static final String EMAIL = "email@domain.com";
    public static final String BAD_EMAIL = "email";

    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected String url;

    @Autowired
    protected MockMvc mvc;
}
