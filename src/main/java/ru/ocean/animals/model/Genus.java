package ru.ocean.animals.model;

import javax.persistence.*;

@Entity
@Table(name = "Genus")
public class Genus {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "genus_name_ru")
    private String genus_name_ru;

    @Column(name = "genus_name_lat")
    private String genus_name_lat;

    @Column(name = "family_id")
    private Long family_id;

    @ManyToOne
    @JoinColumn(
            name = "family_id",
            foreignKey = @ForeignKey(name = "FK_Genus_Family"),
            insertable = false,
            updatable = false)
    private Family family;

    public String getGenusFullName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(genus_name_lat);
        stringBuilder.append(" / ");
        stringBuilder.append(genus_name_ru);
        return stringBuilder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenus_name_ru() {
        return genus_name_ru;
    }

    public void setGenus_name_ru(String genus_name_ru) {
        this.genus_name_ru = genus_name_ru;
    }

    public String getGenus_name_lat() {
        return genus_name_lat;
    }

    public void setGenus_name_lat(String genus_name_lat) {
        this.genus_name_lat = genus_name_lat;
    }

    public Long getFamily_id() {
        return family_id;
    }

    public void setFamily_id(Long family_id) {
        this.family_id = family_id;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Genus{" +
                "id=" + id +
                ", genus_name_ru='" + genus_name_ru + '\'' +
                ", genus_name_lat='" + genus_name_lat + '\'' +
                ", family_id=" + family_id +
                '}';
    }
}
