package ru.ocean.animals.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "Displacement")
public class Displacement {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date_arrival")
    private Timestamp date_arrival;

    @Column(name = "date_departure")
    private Timestamp date_departure;

    @Column(name = "displacement_count")
    private int displacement_count;

    @Column(name = "tank_id")
    private Long tank_id;

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
            name = "object_id",
            foreignKey = @ForeignKey(name = "FK_Displacement_Object"),
            insertable = false,
            updatable = false
    )
    private Object object;

    public Displacement() {
        this.displacement_count = 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_arrival() {
        if(date_arrival != null)
            return sdf.format(date_arrival);
        else
            return "";
    }

    public void setDate_arrival(String date_arrival) {
        try {
            Timestamp timestamp = new Timestamp(sdf.parse(date_arrival).getTime());
            this.date_arrival = timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDate_departure() {
        if(date_departure != null)
            return sdf.format(date_departure);
        else
            return "";
    }

    public void setDate_departure(String date_departure) {
        try {
            this.date_departure = new Timestamp(
                    sdf.parse(date_departure).getTime()
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getDisplacement_count() {
        return displacement_count;
    }

    public void setDisplacement_count(int displacement_count) {
        this.displacement_count = displacement_count;
    }

    public Long getTank_id() {
        return tank_id;
    }

    public void setTank_id(Long tank_id) {
        this.tank_id = tank_id;
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
                //", tank=" + tank +
                //", object=" + object +
                '}';
    }
}
