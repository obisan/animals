package ru.ocean.animals.model;

import javax.persistence.*;

@Entity
@Table(name = "ConditionN")
public class Condition {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "condition_name")
    private String condition_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition_name() {
        return condition_name;
    }

    public void setCondition_name(String condition_name) {
        this.condition_name = condition_name;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "id=" + id +
                ", condition_name='" + condition_name + '\'' +
                '}';
    }
}