package ru.ocean.animals.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Specie")
public class Specie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "specie_name_ru")
    private String specie_name_ru;

    @Column(name = "specie_name_lat")
    private String specie_name_lat;

    @Column(name = "specie_rbc")
    private float specie_rbc;

    @Column(name = "specie_nucleus")
    private float specie_nucleus;

    @Column(name = "genus_id")
    private Long genus_id;

    @Column(name = "tag_id")
    private Long tag_id;

    @ManyToOne
    @JoinColumn(
            name = "genus_id",
            foreignKey = @ForeignKey(name = "FK_Specie_Genus"),
            insertable = false,
            updatable = false
    )
    private Genus genus;

    @ManyToOne
    @JoinColumn(
            name = "tag_id",
            foreignKey = @ForeignKey(name = "FK_Specie_Tag"),
            insertable = false,
            updatable = false
    )
    private Tag tag;

    @OneToMany(
            targetEntity = Object.class,
            mappedBy = "specie",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Object> objects = new HashSet<>();

    @OneToMany(
            targetEntity = Photo.class,
            mappedBy = "specie",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Photo> photos = new HashSet<>();

    public String getSpecieFullName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(specie_name_lat);
        stringBuilder.append(" / ");
        stringBuilder.append(specie_name_ru);
        return stringBuilder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecie_name_ru() {
        return specie_name_ru;
    }

    public void setSpecie_name_ru(String specie_name_ru) {
        this.specie_name_ru = specie_name_ru;
    }

    public String getSpecie_name_lat() {
        return specie_name_lat;
    }

    public void setSpecie_name_lat(String specie_name_lat) {
        this.specie_name_lat = specie_name_lat;
    }

    public float getSpecie_rbc() {
        return specie_rbc;
    }

    public void setSpecie_rbc(float specie_rbc) {
        this.specie_rbc = specie_rbc;
    }

    public float getSpecie_nucleus() {
        return specie_nucleus;
    }

    public void setSpecie_nucleus(float specie_nucleus) {
        this.specie_nucleus = specie_nucleus;
    }

    public void setSpecie_nucleus(Float specie_nucleus) {
        this.specie_nucleus = specie_nucleus;
    }

    public Long getGenus_id() {
        return genus_id;
    }

    public void setGenus_id(Long genus_id) {
        this.genus_id = genus_id;
    }

    public Long getTag_id() {
        return tag_id;
    }

    public void setTag_id(Long tag_id) {
        this.tag_id = tag_id;
    }

    public Genus getGenus() {
        return genus;
    }

    public void setGenus(Genus genus) {
        this.genus = genus;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Set<Object> getObjects() {
        return objects;
    }

    public void setObjects(Set<Object> objects) {
        this.objects = objects;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Specie{" +
                "id=" + id +
                ", specie_name_ru='" + specie_name_ru + '\'' +
                ", specie_name_lat='" + specie_name_lat + '\'' +
                ", specie_rbc=" + specie_rbc +
                ", specie_nucleus=" + specie_nucleus +
                ", genus_id=" + genus_id +
                '}';
    }
}
