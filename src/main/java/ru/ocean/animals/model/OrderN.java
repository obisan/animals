package ru.ocean.animals.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OrderN")
public class OrderN {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_name_ru")
    private String order_name_ru;

    @Column(name = "order_name_lat")
    private String order_name_lat;

    @Column(name = "class_id")
    private Long class_id;

    @ManyToOne
    @JoinColumn(
            name = "class_id",
            foreignKey = @ForeignKey(name = "FK_Order_Class"),
            insertable = false,
            updatable = false)
    private Class aClass;

    @OneToMany(
            targetEntity = Family.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Family> families = new HashSet<>();

    public String getOrderFullName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(order_name_lat);
        stringBuilder.append(" / ");
        stringBuilder.append(order_name_ru);
        return stringBuilder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder_name_ru() {
        return order_name_ru;
    }

    public void setOrder_name_ru(String order_name_ru) {
        this.order_name_ru = order_name_ru;
    }

    public String getOrder_name_lat() {
        return order_name_lat;
    }

    public void setOrder_name_lat(String order_name_lat) {
        this.order_name_lat = order_name_lat;
    }

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Set<Family> getFamilies() {
        return families;
    }

    public void setFamilies(Set<Family> families) {
        this.families = families;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_name_ru='" + order_name_ru + '\'' +
                ", order_name_lat='" + order_name_lat + '\'' +
                ", class_id=" + class_id +
                //", aClass=" + aClass +
                '}';
    }
}
