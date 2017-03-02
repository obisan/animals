package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.MedicationDao;
import ru.ocean.animals.model.Medication;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationDao medicationDao;

    @Transactional("dubinets")
    public void addMedication(Medication medication) {
        this.medicationDao.addMedication(medication);
    }

    @Transactional("dubinets")
    public void updateMedication(Medication medication) {
        this.medicationDao.updateMedication(medication);
    }

    @Transactional("dubinets")
    public Medication getMedicationById(long id) {
        return this.medicationDao.getMedicationById(id);
    }

    @Transactional("dubinets")
    public List<Medication> getMedications() {
        return this.medicationDao.getMedications();
    }

    @Transactional("dubinets")
    public void removeMedication(long id) {
        this.medicationDao.removeMedication(id);
    }
}
