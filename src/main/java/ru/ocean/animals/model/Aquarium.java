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

    public String getNameBraked() {
        StringBuilder sb = new StringBuilder();
        sb.append("(акв. ");
        sb.append(aquarium_name);
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Aquarium{" +
                "id=" + id +
                ", aquarium_name='" + aquarium_name + '\'' +
                '}';
    }
}
