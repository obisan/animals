package ru.ocean.animals.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tank")
public class Tank {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tank_name")
    private String tank_name;

    @Column(name = "tank_volume")
    private String tank_volume;

    @Column(name = "employee_id")
    private Long employee_id;

    @Column(name = "building_id")
    private Long building_id;

    @ManyToOne
    @JoinColumn(
            name        = "employee_id",
            foreignKey  = @ForeignKey(name = "FK_Tank_Employee"),
            insertable  = false,
            updatable   = false
    )
    private Employee employee;

    @ManyToOne
    @JoinColumn(
            name        = "building_id",
            foreignKey  = @ForeignKey(name = "FK_Tank_Building"),
            insertable  = false,
            updatable   = false
    )
    private Building building;

    @OneToMany(
            targetEntity = Object.class,
            mappedBy = "tank",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Object> objects = new HashSet<>();

    @OneToMany(
            targetEntity = Deceased.class,
            mappedBy = "tank",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Deceased> deceaseds = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTank_name() {
        return tank_name;
    }

    public void setTank_name(String tank_name) {
        this.tank_name = tank_name;
    }

    public String getTank_volume() {
        return tank_volume;
    }

    public void setTank_volume(String tank_volume) {
        this.tank_volume = tank_volume;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Long getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(Long building_id) {
        this.building_id = building_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<Object> getObjects() {
        return objects;
    }

    public void setObjects(Set<Object> objects) {
        this.objects = objects;
    }

    public Set<Deceased> getDeceaseds() {
        return deceaseds;
    }

    public void setDeceaseds(Set<Deceased> deceaseds) {
        this.deceaseds = deceaseds;
    }

    public Set<Allowance> getAllowances() {
        Set<Allowance> allowances = new HashSet<>();

        for(Object object : objects) {
            for(JournalAllowance journalAllowance : object.getJournalAllowances()) {
                allowances.add(journalAllowance.getAllowance());
            }
        }

        return allowances;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "id=" + id +
                ", tank_name='" + tank_name + '\'' +
                ", tank_volume='" + tank_volume + '\'' +
                ", employee_id=" + employee_id +
                ", building_id=" + building_id +
                '}';
    }
}
