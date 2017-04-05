package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Medication;

import java.util.List;

@Repository
public class MedicationDaoImpl implements MedicationDao {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addMedication(Medication medication) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(medication);
        logger.info("Medication successfully added. Medication details: " + medication);
    }

    public void updateMedication(Medication medication) {
        Session session = sessionFactory.getCurrentSession();
        session.update(medication);
        logger.info("Medication successfully updated. Medication details: " + medication);
    }

    public Medication getMedicationById(long id) {
        Session session = sessionFactory.getCurrentSession();

        Medication medication = (Medication) session.load(Medication.class, new Long(id));
        logger.info("Medication successfully loaded. Medication details: " + medication);
        return medication;
    }

    @SuppressWarnings("unchecked")
    public List<Medication> getMedications() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Medication>) session.createQuery("from Medication").list();
    }

    public void removeMedication(long id) {
        Session session = sessionFactory.getCurrentSession();

        Medication medication = (Medication) session.load(Medication.class, new Long(id));
        if(medication != null) {
            session.delete(medication);
        }
        logger.info("Medication successfully removed. Medication details: " + medication);
    }
}
