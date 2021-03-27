package br.edu.pucsp.virtualtrainer.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity @IdClass(value = StudentFieldId.class)
public class StudentField {
    @Id
    @ManyToOne
    @JoinColumn(name = "studentId" )
    private Student studentId;

    @Id
    @ManyToOne
    @JoinColumn(name = "fieldId")
    private Field fieldId;

    public StudentField() {
    }

    public StudentField(Student student, Field field) {
        this.studentId = student;
        this.fieldId = field;
    }

    public Student getstudent() {
        return studentId;
    }

    public void setstudent(Student student) {
        this.studentId = student;
    }

    public Field getField() {
        return fieldId;
    }

    public void setField(Field field) {
        this.fieldId = field;
    }
}
