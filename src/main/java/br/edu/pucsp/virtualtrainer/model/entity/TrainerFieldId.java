package br.edu.pucsp.virtualtrainer.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class TrainerFieldId implements Serializable {

    private Long trainerId;

    private Long fieldId;



    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainerFieldId that = (TrainerFieldId) o;
        return trainerId.equals(that.trainerId) && fieldId.equals(that.fieldId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, fieldId);
    }
}
