package br.edu.pucsp.virtualtrainer.transport.response;

import br.edu.pucsp.virtualtrainer.model.dto.SessionDto;

import java.util.List;

public class SessionResponse {

    private List<SessionDto> sessions;

    public List<SessionDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDto> sessions) {
        this.sessions = sessions;
    }
}
