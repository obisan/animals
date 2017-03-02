package ru.ocean.animals.model;

import javax.persistence.*;

@Entity
@Table(name = "Building")
public class Building {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "building_name")
    private String building_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", building_name='" + building_name + '\'' +
                '}';
    }
}
