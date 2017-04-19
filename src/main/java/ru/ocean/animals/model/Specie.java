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

    @Column(name = "specie_weight_adult")
    private Float specie_weight_adult;

    @Column(name = "specie_rbc")
    private Float specie_rbc;

    @Column(name = "specie_nucleus")
    private Float specie_nucleus;

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
        return tags2;
    }

    public void setTags2(List<String> tags2) {
        this.tags2 = tags2;
    }

    public String getSpecieFullName() {
        StringBuilder sb = new StringBuilder();
        sb.append(specie_name_ru);
        sb.append(" / ");
        sb.append(specie_name_lat);
        return sb.toString();
    }

    public String getMessage() {
        if(!specie_author.equals("")) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(specie_author);
            sb.append(")");
            return sb.toString();
        }
        return "";
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

    public Float getSpecie_weight_adult() {
        return specie_weight_adult;
    }

    public void setSpecie_weight_adult(Float specie_weight_adult) {
        this.specie_weight_adult = specie_weight_adult;
    }

    public void setSpecie_name_lat(String specie_name_lat) {
        this.specie_name_lat = specie_name_lat;
    }

    public Float getSpecie_rbc() {
        return specie_rbc;
    }

    public void setSpecie_rbc(Float specie_rbc) {
        this.specie_rbc = specie_rbc;
    }

    public Float getSpecie_nucleus() {
        return specie_nucleus;
    }

    public void setSpecie_nucleus(Float specie_nucleus) {
        this.specie_nucleus = specie_nucleus;
    }

    public String getSpecie_author() {
        return specie_author;
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
                ", specie_weight_adult=" + specie_weight_adult +
                ", specie_rbc=" + specie_rbc +
                ", specie_nucleus=" + specie_nucleus +
                ", specie_author='" + specie_author + '\'' +
                '}';
    }
}
