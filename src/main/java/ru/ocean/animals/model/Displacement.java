package ru.ocean.animals.model;

import ru.ocean.animals.formatter.DateFormatter;
import ru.ocean.animals.formatter.DateFormatterImpl;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Displacement")
public class Displacement {
    private static DateFormatter formatter = DateFormatterImpl.getInstance();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date_arrival")
    private Timestamp date_arrival;

    @Column(name = "date_departure")
    private Timestamp date_departure;

    @Column(name = "displacement_count")
    private Integer displacement_count;

    @Column(name = "tank_id")
    private Long tank_id;

    @Column(name = "aquarium_id")
    private Long aquarium_id;

    @Column(name = "object_id")
    private Long object_id;

    @ManyToOne
    @JoinColumn(
            name = "tank_id",
            foreignKey = @ForeignKey(name = "FK_Displacement_Tank"),
            insertable = false,
            updatable = false
    )
    private Tank tank;

    @ManyToOne
    @JoinColumn(
            name = "aquarium_id",
            foreignKey = @ForeignKey(name = "FK_DIsplacement_Aquarium"),
            insertable = false,
            updatable = false
    )
    private Aquarium aquarium;

    @ManyToOne
    @JoinColumn(
            name = "object_id",
            foreignKey = @ForeignKey(name = "FK_Displacement_Object"),
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

    public String getDate_arrival() {
        return formatter.format2db(date_arrival);
    }

    public void setDate_arrival(String date_arrival) {
        this.date_arrival = formatter.parse(date_arrival);
    }

    public String getDate_departure() {
        return formatter.format2db(date_departure);
    }

    public void setDate_departure(String date_departure) {
        this.date_departure = formatter.parse(date_departure);
    }

    public Integer getDisplacement_count() {
        return displacement_count;
    }

    public void setDisplacement_count(Integer displacement_count) {
        this.displacement_count = displacement_count;
    }

    public Long getTank_id() {
        return tank_id;
    }

    public void setTank_id(Long tank_id) {
        this.tank_id = tank_id;
    }

    public Long getAquarium_id() {
        return aquarium_id;
    }

    public void setAquarium_id(Long aquarium_id) {
        this.aquarium_id = aquarium_id;
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
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

    public Object getObject() {
        return object;
    }

    public Displacement clone() throws CloneNotSupportedException {
        Displacement displacement = new Displacement();
        displacement.setDate_arrival(this.getDate_arrival());
        displacement.setDate_departure(this.getDate_departure());
        displacement.setDisplacement_count(this.displacement_count);
        displacement.setTank_id(this.tank_id);
        displacement.setObject_id(this.object_id);
        return displacement;
    }

    @Override
    public String toString() {
        return "Displacement{" +
                "id=" + id +
                ", date_arrival=" + date_arrival +
                ", date_departure=" + date_departure +
                ", tank_id=" + tank_id +
                ", object_id=" + object_id +
                '}';
    }
}
