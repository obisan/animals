package ru.ocean.animals.model;

import javax.persistence.*;

@Entity
@Table(name = "JournalAllowance")
public class JournalAllowance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "allowance_id")
    private Long allowance_id;

    @Column(name = "object_id")
    private Long object_id;

    @Column(name = "weight")
    private float weight;

    @ManyToOne
    @JoinColumn(
            name = "allowance_id",
            foreignKey = @ForeignKey(name = "FK_JournalAllowance_Allowance"),
            insertable = false,
            updatable = false
    )
    private Allowance allowance;

    @ManyToOne
    @JoinColumn(
            name = "object_id",
            foreignKey = @ForeignKey(name = "FK_JournalAllowance_Object"),
            insertable = false,
            updatable = false
    )
    private Object object;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAllowance_id() {
        return allowance_id;
    }

    public void setAllowance_id(Long allowance_id) {
        this.allowance_id = allowance_id;
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Allowance getAllowance() {
        return allowance;
    }

    public void setAllowance(Allowance allowance) {
        this.allowance = allowance;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "JournalAllowance{" +
                "id=" + id +
                ", allowance_id=" + allowance_id +
                ", object_id=" + object_id +
                ", weight=" + weight +
                '}';
    }
}
