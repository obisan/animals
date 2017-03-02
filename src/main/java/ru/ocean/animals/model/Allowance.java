package ru.ocean.animals.model;

import javax.persistence.*;

@Entity
@Table(name = "Allowance")
public class Allowance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "allowance_name")
    private String allowance_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllowance_name() {
        return allowance_name;
    }

    public void setAllowance_name(String allowance_name) {
        this.allowance_name = allowance_name;
    }

    @Override
    public String toString() {
        return "Allowance{" +
                "id=" + id +
                ", allowance_name='" + allowance_name + '\'' +
                '}';
    }
}
