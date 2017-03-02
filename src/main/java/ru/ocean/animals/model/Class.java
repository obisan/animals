package ru.ocean.animals.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Class")
public class Class {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "class_name_ru")
    private String class_name_ru;

    @Column(name = "class_name_lat")
    private String class_name_lat;

    @OneToMany(
            targetEntity = OrderN.class,
            mappedBy = "aClass",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<OrderN> orders = new HashSet<>();

    public String getClassFullName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(class_name_lat);
        stringBuilder.append(" / ");
        stringBuilder.append(class_name_ru);
        return stringBuilder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClass_name_ru() {
        return class_name_ru;
    }

    public void setClass_name_ru(String class_name_ru) {
        this.class_name_ru = class_name_ru;
    }

    public String getClass_name_lat() {
        return class_name_lat;
    }

    public void setClass_name_lat(String class_name_lat) {
        this.class_name_lat = class_name_lat;
    }

    public Set<OrderN> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderN> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", class_name_ru='" + class_name_ru + '\'' +
                ", class_name_lat='" + class_name_lat + '\'' +
                //", orders=" + orders +
                '}';
    }
}
