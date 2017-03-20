package ru.ocean.animals.model;

import javax.persistence.*;

@Entity
@Table(name = "Drug")
public class Drug {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "drug_name")
    private String drug_name;

    @Column(name = "drug_measuring")
    private Float drug_measuring;

    @Column(name = "drug_dim")
    private String drug_dim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public Float getDrug_measuring() {
        return drug_measuring;
    }

    public void setDrug_measuring(Float drug_measuring) {
        this.drug_measuring = drug_measuring;
    }

    public String getDrug_dim() {
        return drug_dim;
    }

    public void setDrug_dim(String drug_dim) {
        this.drug_dim = drug_dim;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", drug_name='" + drug_name + '\'' +
                '}';
    }
}
