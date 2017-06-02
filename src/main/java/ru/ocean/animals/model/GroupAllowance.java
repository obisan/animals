package ru.ocean.animals.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GroupAllowance")
public class GroupAllowance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "group_name")
    String group_name;

    @ManyToMany
    @JoinTable(
            name = "groupallowance_allowance",
            joinColumns = @JoinColumn(name = "groupallowance_id"),
            inverseJoinColumns = @JoinColumn(name = "allowance_id")
    )
    private Set<Allowance> allowances;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Set<Allowance> getAllowances() {
        return allowances;
    }

    public void setAllowances(Set<Allowance> allowances) {
        this.allowances = allowances;
    }

    @Override
    public String toString() {
        return "GroupAllowance{" +
                "id=" + id +
                ", group_name='" + group_name + '\'' +
                '}';
    }
}
