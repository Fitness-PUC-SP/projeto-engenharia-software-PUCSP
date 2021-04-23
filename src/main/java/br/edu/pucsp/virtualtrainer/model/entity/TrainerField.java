package br.edu.pucsp.virtualtrainer.model.entity;

import javax.persistence.*;

@Entity @IdClass(value = TrainerFieldId.class)
@Table(name = "trainer_field")
public class TrainerField {

    @Id
    @ManyToOne
    @JoinColumn(name = "trainerId" )
    private Trainer trainerId;

    @Id
    @ManyToOne
    @JoinColumn(name = "fieldId")
    private Field fieldId;

    @Column
    @Lob
    private String certificate;

    public TrainerField() {
    }

    public TrainerField(Trainer trainer, Field field) {
        this.trainerId = trainer;
        this.fieldId = field;
    }

    public Trainer getTrainer() {
        return trainerId;
    }

    public void setTrainer(Trainer trainer) {
        this.trainerId = trainer;
    }

    public Field getField() {
        return fieldId;
    }

    public void setField(Field field) {
        this.fieldId = field;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}
