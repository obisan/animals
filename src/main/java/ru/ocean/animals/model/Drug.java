package ru.ocean.animals.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Drug")
public class Drug {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "drug_name")
    private String drug_name;

    @Column(name = "drug_measuring")
    private Float drug_measuring;

    @Column(name = "drug_dim")
    private String drug_dim;

    @Column(name = "drug_annotation")
    private String drug_annotation;

    @Column(name = "drug_vitamin")
    private Boolean drug_vitamin;

    @Column(name = "drug_medicament")
    private Boolean drug_medicament;

    @OneToMany(
            targetEntity    = MedicationDrugs.class,
            mappedBy        = "drug",
            cascade         = CascadeType.ALL,
            fetch           = FetchType.LAZY
    )
    private Set<MedicationDrugs> medicationDrugss = new HashSet<>();

    @ManyToMany(mappedBy = "drugs")
    private Set<Vitaminization> vitaminizations;

    public String getMessage() {
        if(drug_medicament && drug_vitamin) return "Л В";
        if(drug_medicament) return "Л";
        if(drug_vitamin) return "В";
        return "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public Float getDrug_measuring() {
        return drug_measuring;
    }

    public void setDrug_measuring(Float drug_measuring) {
        this.drug_measuring = drug_measuring;
    }

    public String getDrug_dim() {
        return drug_dim;
    }

    public void setDrug_dim(String drug_dim) {
        this.drug_dim = drug_dim;
    }

    public String getDrug_annotation() {
        return drug_annotation;
    }

    public void setDrug_annotation(String drug_annotation) {
        this.drug_annotation = drug_annotation;
    }

    public Boolean getDrug_vitamin() {
        return drug_vitamin;
    }

    public void setDrug_vitamin(Boolean drug_vitamin) {
        this.drug_vitamin = drug_vitamin;
    }

    public Boolean getDrug_medicament() {
        return drug_medicament;
    }

    public void setDrug_medicament(Boolean drug_medicament) {
        this.drug_medicament = drug_medicament;
    }

    public Set<MedicationDrugs> getMedicationDrugss() {
        return medicationDrugss;
    }

    public void setMedicationDrugss(Set<MedicationDrugs> medicationDrugss) {
        this.medicationDrugss = medicationDrugss;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", drug_name='" + drug_name + '\'' +
                ", drug_measuring=" + drug_measuring +
                ", drug_dim='" + drug_dim + '\'' +
                ", drug_annotation='" + drug_annotation + '\'' +
                ", drug_vitamin=" + drug_vitamin +
                ", drug_medicament=" + drug_medicament +
                '}';
    }
}
