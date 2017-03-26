package ru.ocean.animals.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Object")
public class Object {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "object_name")
    private String  object_name;

    @Column(name = "object_count")
    private Integer object_count;

    @Column(name = "object_length")
    private Float object_length;

    @Column(name = "object_weight")
    private Float object_weight;

    @Column(name = "specie_id")
    private Long specie_id;

    @Column(name = "employee_id")
    private Long employee_id;

    @Column(name = "label_id")
    private Long label_id;

    @Column(name = "tank_id")
    private Long tank_id;

    @Column(name = "aquarium_id")
    private Long aquarium_id;

    @Column(name = "parent_id")
    private Long parent_id;

    @ManyToOne
    @JoinColumn(
            name = "specie_id",
            foreignKey = @ForeignKey(name = "FK_Object_Specie"),
            insertable = false,
            updatable = false
    )
    private Specie specie;

    @ManyToOne
    @JoinColumn(
            name = "employee_id",
            foreignKey = @ForeignKey(name = "FK_Object_Employee"),
            insertable = false,
            updatable = false
    )
    private Employee employee;

    @ManyToOne
    @JoinColumn(
            name = "label_id",
            foreignKey = @ForeignKey(name = "FK_Object_Label"),
            insertable = false,
            updatable = false
    )
    private Label label;

    @ManyToOne
    @JoinColumn(
            name = "tank_id",
            foreignKey = @ForeignKey(name = "FK_Object_Tank"),
            insertable = false,
            updatable = false
    )
    private Tank tank;

    @ManyToOne
    @JoinColumn(
            name = "aquarium_id",
            foreignKey = @ForeignKey(name = "FK_Object_Aquarium"),
            insertable = false,
            updatable = false
    )
    private Aquarium aquarium;

    @ManyToOne
    @JoinColumn(
            name = "parent_id",
            foreignKey = @ForeignKey(name = "FK_Object_Parent"),
            insertable = false,
            updatable = false
    )
    private Object parent;

    @OneToMany(
            targetEntity = Displacement.class,
            mappedBy = "object",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Displacement> displacements = new HashSet<>();

    @OneToMany(
            targetEntity = Quarantine.class,
            mappedBy = "object",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Quarantine> quarantines = new HashSet<>();

    @OneToMany(
            targetEntity = Deceased.class,
            mappedBy = "object",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Deceased> deceaseds = new HashSet<>();

    @OneToMany(
            targetEntity = Certificate.class,
            mappedBy = "object",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Certificate> certificates = new HashSet<>();

    @OneToMany(
            targetEntity = JournalAllowance.class,
            mappedBy = "object",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<JournalAllowance> journalAllowances = new HashSet<>();

    public void increase(int n) {
        this.object_count += n;
    }

    public void decrease(int n) {
        this.object_count -= n;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObject_name() {
        return object_name;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public Integer getObject_count() {
        return object_count;
    }

    public void setObject_count(Integer object_count) {
        this.object_count = object_count;
    }

    public Float getObject_length() {
        return object_length;
    }

    public void setObject_length(Float object_length) {
        this.object_length = object_length;
    }

    public Float getObject_weight() {
        return object_weight;
    }

    public void setObject_weight(Float object_weight) {
        this.object_weight = object_weight;
    }

    public Long getSpecie_id() {
        return specie_id;
    }

    public void setSpecie_id(Long specie_id) {
        this.specie_id = specie_id;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Long getLabel_id() {
        return label_id;
    }

    public void setLabel_id(Long label_id) {
        this.label_id = label_id;
    }

    public Long getTank_id() {
        return tank_id;
    }

    public void setTank_id(Long tank_id) {
        this.tank_id = tank_id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Long getAquarium_id() {
        return aquarium_id;
    }

    public void setAquarium_id(Long aquarium_id) {
        this.aquarium_id = aquarium_id;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Aquarium getAquarium() {
        return aquarium;
    }

    public void setAquarium(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public Set<Displacement> getDisplacements() {
        return displacements;
    }

    public void setDisplacements(Set<Displacement> displacements) {
        this.displacements = displacements;
    }

    public Set<Quarantine> getQuarantines() {
        return quarantines;
    }

    public void setQuarantines(Set<Quarantine> quarantines) {
        this.quarantines = quarantines;
    }

    public Set<Deceased> getDeceaseds() {
        return deceaseds;
    }

    public void setDeceaseds(Set<Deceased> deceaseds) {
        this.deceaseds = deceaseds;
    }

    public Set<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<Certificate> certificates) {
        this.certificates = certificates;
    }

    public Set<JournalAllowance> getJournalAllowances() {
        return journalAllowances;
    }

    public void setJournalAllowances(Set<JournalAllowance> journalAllowances) {
        this.journalAllowances = journalAllowances;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = new Object();
        object.setObject_name(      this.object_name);
        object.setObject_length(    this.object_length);
        object.setObject_count(     this.object_count);
        object.setObject_weight(    this.object_weight);
        object.setSpecie_id(        this.specie_id);
        object.setEmployee_id(      this.employee_id);
        object.setLabel_id(         this.label_id);
        object.setTank_id(          this.tank_id);
        return object;
    }

    @Override
    public String toString() {
        return "Object{" +
                "id=" + id +
                ", object_name='" + object_name + '\'' +
                ", object_length=" + object_length +
                ", object_count=" + object_count +
                ", object_weight=" + object_weight +
                ", specie_id=" + specie_id +
                ", employee_id=" + employee_id +
                ", label_id=" + label_id +
                ", tank_id=" + tank_id +
                ", parent_id= " + parent_id +
                '}';
    }
}
