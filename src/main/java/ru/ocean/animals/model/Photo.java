package ru.ocean.animals.model;

import javax.persistence.*;

@Entity
@Table(name = "Photo")
public class Photo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "photo_link")
    private String  photo_link;

    @Column(name = "specie_id")
    private Long    specie_id;

    @ManyToOne
    @JoinColumn(
            name = "specie_id",
            foreignKey = @ForeignKey(name = "FK_Photo_Specie"),
            insertable = false,
            updatable = false
    )
    private Specie specie;

    public Photo() {
    }

    public Photo(String photo_link) {
        this.photo_link = photo_link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto_link() {
        return photo_link;
    }

    public void setPhoto_link(String photo_link) {
        this.photo_link = photo_link;
    }

    public Long getSpecie_id() {
        return specie_id;
    }

    public void setSpecie_id(Long specie_id) {
        this.specie_id = specie_id;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", photo_link='" + photo_link + '\'' +
                ", specie_id=" + specie_id +
                '}';
    }
}
