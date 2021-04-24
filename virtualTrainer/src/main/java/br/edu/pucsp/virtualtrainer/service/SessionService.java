package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.transport.request.SessionRequest;
import br.edu.pucsp.virtualtrainer.transport.response.SessionResponse;

public interface SessionService {

    void createSession(SessionRequest request);
    void updateSession(SessionRequest request);
    SessionResponse getSessions(Long studentId);
}
