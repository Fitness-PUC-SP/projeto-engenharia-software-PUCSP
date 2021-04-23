package br.edu.pucsp.virtualtrainer.model.entity;

import javax.persistence.*;

@Entity
public class Field {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;

    @Column(nullable = false)
    private boolean certified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }
}
