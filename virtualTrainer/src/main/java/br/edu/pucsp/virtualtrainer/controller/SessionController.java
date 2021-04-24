package br.edu.pucsp.virtualtrainer.controller;

import br.edu.pucsp.virtualtrainer.service.SessionService;
import br.edu.pucsp.virtualtrainer.transport.request.SessionRequest;
import br.edu.pucsp.virtualtrainer.transport.response.SessionResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/session", produces = APPLICATION_JSON_VALUE)
public class SessionController {

    private SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @ApiOperation(value = "Creates a new appointment between a trainer and a student")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSession(
            @RequestBody @Valid SessionRequest request){
        sessionService.createSession(request);
    }

    @ApiOperation(value = "Updates an appointment")
    @PutMapping
    public void updateSession(
            @RequestBody @Valid SessionRequest request){
        sessionService.createSession(request);
    }

    @ApiOperation(value = "Updates an appointment")
    @GetMapping(path = "/{studentId}")
    public SessionResponse getSessions(
            @PathVariable Long studentId){
        return sessionService.getSessions(studentId);
    }


}
