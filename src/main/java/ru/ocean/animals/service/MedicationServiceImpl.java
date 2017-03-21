package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.MedicationDao;
import ru.ocean.animals.dao.MedicationDrugsDao;
import ru.ocean.animals.model.Drug;
import ru.ocean.animals.model.Medication;
import ru.ocean.animals.model.MedicationDrugs;
import ru.ocean.animals.model.MedicationExtended;

import java.util.List;
import java.util.Set;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationDao medicationDao;

    @Autowired
    private MedicationDrugsDao medicationDrugsDao;

    @Transactional("dubinets")
    public void addMedication(Medication medication, List<Drug> drugs) {
        this.medicationDao.addMedication(medication);

        for(Drug drug : drugs) {
            if(drug.getId() != null) {
                MedicationDrugs medicationDrugs = new MedicationDrugs();
                medicationDrugs.setDrug_id(drug.getId());
                medicationDrugs.setMedication_id(medication.getId());

                this.medicationDrugsDao.addMedicationDrugs(medicationDrugs);
            }
        }
    }

    @Transactional("dubinets")
    public void updateMedication(Medication medication, List<Drug> drugs) {


        for(Drug drug : drugs) {
            if(drug.getId() != null) {
                MedicationDrugs medicationDrugs = new MedicationDrugs();
                medicationDrugs.setDrug_id(drug.getId());
                medicationDrugs.setMedication_id(medication.getId());
                this.medicationDrugsDao.addMedicationDrugs(medicationDrugs);
            }
        }

        this.medicationDao.updateMedication(medication);
    }

    @Transactional("dubinets")
    public Medication getMedicationById(long id) {
        return this.medicationDao.getMedicationById(id);
    }

    @Transactional("dubinets")
    public MedicationExtended getMedicationExtendedById(long id) {
        MedicationExtended medicationExtended = new MedicationExtended();
        medicationExtended.setMedication(
                this.medicationDao.getMedicationById(id)
        );

        Set<MedicationDrugs> drugs = medicationExtended.getMedication().getMedicationDrugss();

        if(drugs.size() >= 1) {
            medicationExtended.setDrug1(((MedicationDrugs) drugs.toArray()[0]).getDrug());
        }
        if(drugs.size() >= 2) {
            medicationExtended.setDrug2(((MedicationDrugs) drugs.toArray()[1]).getDrug());
        }
        if(drugs.size() >= 3) {
            medicationExtended.setDrug3(((MedicationDrugs) drugs.toArray()[2]).getDrug());
        }
        if(drugs.size() == 4) {
            medicationExtended.setDrug4(((MedicationDrugs) drugs.toArray()[3]).getDrug());
        }

        return medicationExtended;
    }

    @Transactional("dubinets")
    public List<Medication> getMedications() {
        return this.medicationDao.getMedications();
    }

    @Transactional("dubinets")
    public void removeAllAssigmentByMedication(Medication medication) {
        for(MedicationDrugs medicationDrugs : medication.getMedicationDrugss()) {
            this.medicationDrugsDao.removeMedicationDrugs(medicationDrugs.getId());
        }

        this.medicationDao.updateMedication(medication);
    }

    @Transactional("dubinets")
    public void removeMedication(long id) {
        this.medicationDao.removeMedication(id);
    }
}
