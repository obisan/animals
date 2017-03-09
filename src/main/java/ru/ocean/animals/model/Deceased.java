package ru.ocean.animals.model;

import ru.ocean.animals.formatter.DateFormatter;
import ru.ocean.animals.formatter.DateFormatterImpl;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Deceased")
public class Deceased {
    private static DateFormatter formatter = DateFormatterImpl.getInstance();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "deceased_count")
    private Integer deceased_count;

    @Column(name = "deceased_date")
    private Timestamp deceased_date;

    @Column(name = "deceased_note")
    private String deceased_note;

    @Column(name = "object_id")
    private Long object_id;

    @Column(name = "tank_id")
    private Long tank_id;

    @ManyToOne
    @JoinColumn(
            name = "object_id",
            foreignKey = @ForeignKey(name = "FK_Deceased_Object"),
            insertable = false,
            updatable = false
    )
    private Object object;

    @ManyToOne
    @JoinColumn(
            name = "tank_id",
            foreignKey = @ForeignKey(name = "FK_Deceased_Tank"),
            insertable = false,
            updatable = false
    )
    private Tank tank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeceased_count() {
        return deceased_count;
    }

    public void setDeceased_count(Integer deceased_count) {
        this.deceased_count = deceased_count;
    }

    public String getDeceased_date() {
        return formatter.format2db(deceased_date);
    }

    public void setDeceased_date(String deceased_date) {
        this.deceased_date = formatter.parse(deceased_date);
    }

    public String getDeceased_note() {
        return deceased_note;
    }

    public void setDeceased_note(String deceased_note) {
        this.deceased_note = deceased_note;
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public Long getTank_id() {
        return tank_id;
    }

    public void setTank_id(Long tank_id) {
        this.tank_id = tank_id;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Deceased clone() throws CloneNotSupportedException {
        Deceased deceased = new Deceased();
        deceased.setDeceased_date(this.getDeceased_date());
        deceased.setDeceased_count(this.deceased_count);
        deceased.setDeceased_note(this.deceased_note);
        deceased.setObject_id(this.object_id);
        return deceased;
    }

    @Override
    public String toString() {
        return "Deceased{" +
                "id=" + id +
                ", deceased_count=" + deceased_count +
                ", deceased_date=" + deceased_date +
                ", deceased_note='" + deceased_note + '\'' +
                ", object_id=" + object_id +
                ", tank_id=" + tank_id +
                '}';
    }
}
