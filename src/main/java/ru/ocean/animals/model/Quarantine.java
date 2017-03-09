package ru.ocean.animals.model;

import ru.ocean.animals.formatter.DateFormatter;
import ru.ocean.animals.formatter.DateFormatterImpl;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Quarantine")
public class Quarantine implements Cloneable {
    private static DateFormatter formatter = DateFormatterImpl.getInstance();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quarantine_date_start")
    private Timestamp quarantine_date_start;

    @Column(name = "quarantine_period")
    private Integer quarantine_period;

    @Column(name = "quarantine_note")
    private String quarantine_note;

    @Column(name = "object_id")
    private Long object_id;

    @ManyToOne
    @JoinColumn(
            name = "object_id",
            foreignKey = @ForeignKey(name = "FK_Quarantine_Object"),
            insertable = false,
            updatable = false)
    private Object object;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getQuarantine_date_start() {
        return formatter.format2db(quarantine_date_start);
    }

    public void setQuarantine_date_start(String quarantine_date_start) {
        this.quarantine_date_start = formatter.parse(quarantine_date_start);
    }

    public Integer getQuarantine_period() {
        return quarantine_period;
    }

    public void setQuarantine_period(Integer quarantine_period) {
        this.quarantine_period = quarantine_period;
    }

    public String getQuarantine_date_end() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(quarantine_date_start.getTime()));
        c.add(Calendar.DATE, this.quarantine_period);
        return formatter.format2db(new Timestamp(c.getTime().getTime()));
    }

    public String getQuarantine_note() {
        return quarantine_note;
    }

    public void setQuarantine_note(String quarantine_note) {
        this.quarantine_note = quarantine_note;
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public Quarantine clone() throws CloneNotSupportedException {
        Quarantine quarantine = new Quarantine();
        quarantine.setQuarantine_date_start(this.getQuarantine_date_start());
        quarantine.setQuarantine_period(this.quarantine_period);
        quarantine.setQuarantine_note(this.quarantine_note);
        quarantine.setObject_id(this.object_id);
        return quarantine;
    }

    @Override
    public String toString() {
        return "Quarantine{" +
                "id=" + id +
                ", quarantine_date_start=" + quarantine_date_start +
                ", quarantine_period=" + quarantine_period +
                ", object_id=" + object_id +
                //", object=" + object +
                '}';
    }
}
