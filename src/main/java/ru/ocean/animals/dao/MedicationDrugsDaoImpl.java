package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.MedicationDrugs;

import java.util.List;

@Repository
public class MedicationDrugsDaoImpl implements MedicationDrugsDao {
    private static final Logger logger = LoggerFactory.getLogger(MedicationDrugsDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addMedicationDrugs(MedicationDrugs medicationDrugs) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(medicationDrugs);
        logger.info("MedicationDrugs successfully added. MedicationDrugs details: " + medicationDrugs);
    }

    @Override
    public void updateMedicationDrugs(MedicationDrugs medicationDrugs) {
        Session session = sessionFactory.getCurrentSession();
        session.update(medicationDrugs);
        logger.info("MedicationDrugs successfully updated. MedicationDrugs details: " + medicationDrugs);
    }

    @Override
    public MedicationDrugs getMedicationDrugsById(long id) {
        Session session = sessionFactory.getCurrentSession();

        MedicationDrugs medicationDrugs = (MedicationDrugs) session.load(MedicationDrugs.class, new Long(id));
        logger.info("MedicationDrugs successfully loaded. MedicationDrugs details: " + medicationDrugs);
        return medicationDrugs;
    }

    @SuppressWarnings("unchecked")
    public List<MedicationDrugs> getMedicationDrugs() {
        Session session = sessionFactory.getCurrentSession();

        List<MedicationDrugs> medicationDrugss = session.createQuery("from medication_drugs").list();
        logger.info("MedicationDrugs list successfully loaded. MedicationDrugs details: " + medicationDrugss);
        return medicationDrugss;
    }

    @Override
    public void removeMedicationDrugs(long id) {
        Session session = sessionFactory.getCurrentSession();

        MedicationDrugs medicationDrugs = (MedicationDrugs) session.load(MedicationDrugs.class, new Long(id));
        if(medicationDrugs != null) {
            session.delete(medicationDrugs);
        }
        logger.info("MedicationDrugs successfully loaded. MedicationDrugs details: " + medicationDrugs);
    }
}
