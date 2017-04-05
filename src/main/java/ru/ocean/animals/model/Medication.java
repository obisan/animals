package ru.ocean.animals.model;

import ru.ocean.animals.formatter.DateFormatter;
import ru.ocean.animals.formatter.DateFormatterImpl;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Medication")
public class Medication {
    private static DateFormatter formatter = DateFormatterImpl.getInstance();

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

    @ManyToOne
    @JoinColumn(
            name = "object_id",
            foreignKey = @ForeignKey(name = "FK_Medication_Object"),
            insertable = false,
            updatable = false
    )
    private Object object;

    @OneToMany(
            targetEntity    = MedicationDrugs.class,
            mappedBy        = "medication",
            cascade         = CascadeType.ALL,
            fetch           = FetchType.LAZY
    )
    private Set<MedicationDrugs> medicationDrugss = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedication_start_date() {
        return formatter.format2db(medication_start_date);
    }

    public void setMedication_start_date(String medication_start_date) {
        this.medication_start_date = formatter.parse(medication_start_date);
    }

    public String getMedication_end_date() {
        return formatter.format2db(medication_end_date);
    }

    public void setMedication_end_date(String medication_end_date) {
        this.medication_end_date = formatter.parse(medication_end_date);
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Set<MedicationDrugs> getMedicationDrugss() {
        return medicationDrugss;
    }

    public void setMedicationDrugss(Set<MedicationDrugs> medicationDrugss) {
        this.medicationDrugss = medicationDrugss;
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
