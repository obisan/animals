package ru.ocean.animals.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Tag")
public class Tag implements Serializable {
    private static final long serialVersionUID = 5754104541168320730L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tag_name")
    private String tag_name;

    @ManyToMany(mappedBy = "tags")
    private Set<Specie> species;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public Set<Specie> getSpecies() {
        return species;
    }

    public void setSpecies(Set<Specie> species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tag_name='" + tag_name + '\'' +
                '}';
    }
}
