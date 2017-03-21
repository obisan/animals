package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Certificate;

import java.util.List;

@Repository
public class CertificateDaoImpl implements CertificateDao {
    private static final Logger logger = LoggerFactory.getLogger(CertificateDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addCertificate(Certificate certificate) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(certificate);
        logger.info("Certificate successfully added. Certificate details: " + certificate);

    }

    public void updateCertificate(Certificate certificate) {
        Session session = sessionFactory.getCurrentSession();
        session.update(certificate);
        logger.info("Certificate successfully updated. Certificate details: " + certificate);
    }

    public Certificate getCertificateById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Certificate certificate = (Certificate) session.load(Certificate.class, new Long(id));
        logger.info("Certificate successfully loaded. Certificate details: " + certificate);
        return certificate;
    }

    @SuppressWarnings("unchecked")
    public List<Certificate> getCertificates() {
        Session session = sessionFactory.getCurrentSession();

        List<Certificate> certificates = session.createQuery("from Certificate").list();
        logger.info("Certificate list successfully loaded. Certificate details: " + certificates);
        return certificates;
    }

    public void removeCertificate(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Certificate certificate = (Certificate) session.load(Certificate.class, new Long(id));
        if(certificate != null) {
            session.delete(certificate);
        }
        logger.info("Certificate successfully removed. Certificate details: " + certificate);
    }
}
