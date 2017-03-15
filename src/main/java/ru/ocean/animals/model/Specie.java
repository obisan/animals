package ru.ocean.animals.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Specie")
public class Specie {
    private static final long serialVersionUID = 5754104541168320730L;

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

    @Column(name = "specie_author")
    private String specie_author;

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

    @ManyToMany
    @JoinTable(
            name = "specie_tags",
            joinColumns = @JoinColumn(name = "specie_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @Transient
    private List<String> tags2 = new ArrayList<>();

    public List<String> getTags2() {
        //tags2.add("get2");
        return tags2;
    }

    public void setTags2(List<String> tags2) {
        //tags2.add("set2");
        this.tags2 = tags2;
    }

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

    public String getSpecie_author() {
        return specie_author;
    }

    public String getSpecie_author_bracket() {
        if(specie_author != null)
            return specie_author;
        return null;
    }

    public void setSpecie_author(String specie_author) {
        this.specie_author = specie_author;
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Specie{" +
                "id=" + id +
                ", specie_name_ru='" + specie_name_ru + '\'' +
                ", specie_name_lat='" + specie_name_lat + '\'' +
                ", specie_rbc=" + specie_rbc +
                ", specie_nucleus=" + specie_nucleus +
                ", specie_author='" + specie_author + '\'' +
                '}';
    }
}
