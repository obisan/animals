package ru.ocean.animals.model;

import javax.persistence.*;

@Entity
@Table(name = "Aquarium")
public class Aquarium {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "aquarium_name")
    private String aquarium_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAquarium_name() {
        return aquarium_name;
    }

    public void setAquarium_name(String aquarium_name) {
        this.aquarium_name = aquarium_name;
    }

    @Override
    public String toString() {
        return "Aquarium{" +
                "id=" + id +
                ", aquarium_name='" + aquarium_name + '\'' +
                '}';
    }
}
