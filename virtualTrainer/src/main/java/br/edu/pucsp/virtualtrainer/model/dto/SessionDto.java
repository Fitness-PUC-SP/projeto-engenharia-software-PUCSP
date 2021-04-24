package br.edu.pucsp.virtualtrainer.model.dto;

import java.time.LocalDateTime;

public class SessionDto {

    private Long id;

    private TrainerDto trainer;

    private FieldDto field;

    private LocalDateTime schedule;

    private Integer length;

    private boolean confirmed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainerDto getTrainer() {
        return trainer;
    }

    public void setTrainer(TrainerDto trainer) {
        this.trainer = trainer;
    }

    public FieldDto getField() {
        return field;
    }

    public void setField(FieldDto field) {
        this.field = field;
    }

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
