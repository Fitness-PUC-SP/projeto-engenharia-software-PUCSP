package br.edu.pucsp.virtualtrainer.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Session {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate schedule;

    @Column(nullable = false)
    private Integer length;

    @ManyToOne(optional = false)
    @JoinColumn(name = "trainer", referencedColumnName = "id")
    private Trainer trainer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "field", referencedColumnName = "id")
    private Field field;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student", referencedColumnName = "id")
    private Student student;

    @Column(nullable = false)
    private boolean confirmed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
