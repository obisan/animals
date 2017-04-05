package ru.ocean.animals.model;

import javax.persistence.*;

@Entity
@Table(name = "medication_drugs")
public class MedicationDrugs {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "drug_id")
    private Long drug_id;

    @Column(name = "medication_id")
    private Long medication_id;

    @Column(name = "drug_measuring")
    private Float drug_measuring;

    @ManyToOne
    @JoinColumn(
            name        = "medication_id",
            foreignKey  = @ForeignKey(name = "FK_MedicationDrugs_Medication"),
            insertable  = false,
            updatable   = false
    )
    private Medication medication;

    @ManyToOne
    @JoinColumn(
            name = "drug_id",
            foreignKey = @ForeignKey(name = "FK_MedicationDrug_Drug"),
            insertable = false,
            updatable = false
    )
    private Drug drug;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(Long drug_id) {
        this.drug_id = drug_id;
    }

    public Long getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Long medication_id) {
        this.medication_id = medication_id;
    }

    public Float getDrug_measuring() {
        return drug_measuring;
    }

    public void setDrug_measuring(Float drug_measuring) {
        this.drug_measuring = drug_measuring;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
