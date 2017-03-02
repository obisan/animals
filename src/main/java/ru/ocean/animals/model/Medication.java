package ru.ocean.animals.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "Medication")
public class Medication {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "medication_start_date")
    private Timestamp medication_start_date;

    @Column(name = "medication_end_date")
    private Timestamp medication_end_date;

    @Column(name = "medication_reaction")
    private String medication_reaction;

    @Column(name = "medication_note")
    private String medication_note;

    @Column(name = "medication_diagnostic")
    private String medication_diagnostic;

    @Column(name = "medication_bath")
    private String medication_bath;

    @Column(name = "object_id")
    private Long object_id;

    @Column(name = "drug_id")
    private Long drug_id;

    @ManyToOne
    @JoinColumn(
            name = "drug_id",
            foreignKey = @ForeignKey(name = "FK_Medication_Drug"),
            insertable = false,
            updatable = false
    )
    private Drug drug;

    @ManyToOne
    @JoinColumn(
            name = "object_id",
            foreignKey = @ForeignKey(name = "FK_Medication_Object"),
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

    public String getMedication_start_date() {
        if(medication_start_date != null)
            return sdf.format(medication_start_date);
        else
            return "";
    }

    public void setMedication_start_date(String medication_start_date) {
        try {
            Timestamp timestamp = new Timestamp(sdf.parse(medication_start_date).getTime());
            this.medication_start_date = timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getMedication_end_date() {
        if(medication_end_date != null)
            return sdf.format(medication_end_date);
        else
            return "";
    }

    public void setMedication_end_date(String medication_end_date) {
        try {
            Timestamp timestamp = new Timestamp(sdf.parse(medication_end_date).getTime());
            this.medication_end_date = timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getMedication_reaction() {
        return medication_reaction;
    }

    public void setMedication_reaction(String medication_reaction) {
        this.medication_reaction = medication_reaction;
    }

    public String getMedication_note() {
        return medication_note;
    }

    public void setMedication_note(String medication_note) {
        this.medication_note = medication_note;
    }

    public String getMedication_diagnostic() {
        return medication_diagnostic;
    }

    public void setMedication_diagnostic(String medication_diagnostic) {
        this.medication_diagnostic = medication_diagnostic;
    }

    public String getMedication_bath() {
        return medication_bath;
    }

    public void setMedication_bath(String medication_bath) {
        this.medication_bath = medication_bath;
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public Long getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(Long drug_id) {
        this.drug_id = drug_id;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", medication_start_date=" + medication_start_date +
                ", medication_end_date=" + medication_end_date +
                ", medication_reaction='" + medication_reaction + '\'' +
                ", medication_note='" + medication_note + '\'' +
                ", medication_diagnostic='" + medication_diagnostic + '\'' +
                ", medication_bath='" + medication_bath + '\'' +
                '}';
    }
}
