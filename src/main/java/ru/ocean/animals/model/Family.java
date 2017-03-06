package ru.ocean.animals.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Family")
public class Family {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "family_name_ru")
    private String family_name_ru;

    @Column(name = "family_name_lat")
    private String family_name_lat;

    @Column(name = "order_id")
    private Long order_id;

    @ManyToOne
    @JoinColumn(
            name = "order_id",
            foreignKey = @ForeignKey(name = "FK_Family_Order"),
            insertable = false,
            updatable = false
    )
    private OrderN order;

    @OneToMany(
            targetEntity = Genus.class,
            mappedBy = "family",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Genus> genera = new HashSet<>();

    public String getFamilyFullName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(family_name_lat);
        stringBuilder.append(" / ");
        stringBuilder.append(family_name_ru);
        return stringBuilder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamily_name_ru() {
        return family_name_ru;
    }

    public void setFamily_name_ru(String family_name_ru) {
        this.family_name_ru = family_name_ru;
    }

    public String getFamily_name_lat() {
        return family_name_lat;
    }

    public void setFamily_name_lat(String family_name_lat) {
        this.family_name_lat = family_name_lat;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public OrderN getOrder() {
        return order;
    }

    public void setOrder(OrderN order) {
        this.order = order;
    }

    public Set<Genus> getGenera() {
        return genera;
    }

    public void setGenera(Set<Genus> genera) {
        this.genera = genera;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", family_name_ru='" + family_name_ru + '\'' +
                ", family_name_lat='" + family_name_lat + '\'' +
                ", order_id=" + order_id +
                //", order=" + order +
                '}';
    }
}
