package br.edu.pucsp.virtualtrainer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractControllerTest{

    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected String url;

    @Autowired
    protected MockMvc mvc;
}
