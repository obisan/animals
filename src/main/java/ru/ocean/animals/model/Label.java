package ru.ocean.animals.model;

import ru.ocean.animals.formatter.DateFormatter;
import ru.ocean.animals.formatter.DateFormatterImpl;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Label")
public class Label {
    private static DateFormatter formatter = DateFormatterImpl.getInstance();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "weight")
    private Float   weight;

    @Column(name = "length")
    private Float   length;

    @Column(name = "place_catching")
    private String  place_catching;

    @Column(name = "tool_catching")
    private String  tool_catching;

    @Column(name = "date_catching")
    private Timestamp date_catching;

    @Column(name = "condition_id")
    private Long    condition_id;

    @ManyToOne
    @JoinColumn(
            name        = "condition_id",
            foreignKey  = @ForeignKey(name = "FK_Label_Condition"),
            insertable  = false,
            updatable   = false
    )
    private Condition condition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public String getPlace_catching() {
        return place_catching;
    }

    public void setPlace_catching(String place_catching) {
        this.place_catching = place_catching;
    }

    public String getTool_catching() {
        return tool_catching;
    }

    public void setTool_catching(String tool_catching) {
        this.tool_catching = tool_catching;
    }

    public String getDate_catching() {
        return formatter.format2db(date_catching);
    }

    public void setDate_catching(String date_catching) {
        this.date_catching = formatter.parse(date_catching);
    }

    public Long getCondition_id() {
        return condition_id;
    }

    public void setCondition_id(Long condition_id) {
        this.condition_id = condition_id;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getLabelInfo() {
        return place_catching + " / " + date_catching + " / " + tool_catching;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", place_catching='" + place_catching + '\'' +
                ", tool_catching='" + tool_catching + '\'' +
                ", condition_id=" + condition_id +
                '}';
    }
}
