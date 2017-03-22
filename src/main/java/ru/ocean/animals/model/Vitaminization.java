package ru.ocean.animals.model;

import ru.ocean.animals.formatter.DateFormatter;
import ru.ocean.animals.formatter.DateFormatterImpl;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Vitaminization")
public class Vitaminization {
    private static DateFormatter formatter = DateFormatterImpl.getInstance();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vitaminization_date")
    private Timestamp vitaminization_date;

    @Column(name = "object_id")
    private Long object_id;

    @ManyToOne
    @JoinColumn(
            name = "object_id",
            foreignKey = @ForeignKey(name = "FK_Vitaminization_Object"),
            insertable = false,
            updatable = false
    )
    private Object object;

    @ManyToMany
    @JoinTable(
            name = "vitaminization_drugs",
            joinColumns = @JoinColumn(name = "vitaminization_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_id")
    )
    private Set<Drug> drugs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVitaminization_date() {
        return formatter.format2db(vitaminization_date);
    }

    public void setVitaminization_date(String vitaminization_date) {
        this.vitaminization_date = formatter.parse(vitaminization_date);
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Set<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(Set<Drug> drugs) {
        this.drugs = drugs;
    }

    @Override
    public String toString() {
        return "Vitaminization{" +
                "id=" + id +
                ", vitaminization_date=" + vitaminization_date +
                ", object_id=" + object_id +
                '}';
    }
}
