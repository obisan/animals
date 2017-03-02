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

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", drug_name='" + drug_name + '\'' +
                '}';
    }
}
