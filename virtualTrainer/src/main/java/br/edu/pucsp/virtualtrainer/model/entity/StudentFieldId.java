package br.edu.pucsp.virtualtrainer.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class StudentFieldId implements Serializable  {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long studentId;

    private Long fieldId;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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
        StudentFieldId that = (StudentFieldId) o;
        return studentId.equals(that.studentId) && fieldId.equals(that.fieldId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, fieldId);
    }
}
