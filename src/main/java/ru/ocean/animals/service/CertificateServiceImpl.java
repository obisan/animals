package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.CertificateDao;
import ru.ocean.animals.model.Certificate;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateDao certificateDao;

    @Transactional("dubinets")
    public void addCertificate(Certificate certificate) {
        this.certificateDao.addCertificate(certificate);
    }

    @Transactional("dubinets")
    public void updateCertificate(Certificate certificate) {
        this.certificateDao.updateCertificate(certificate);
    }

    @Transactional("dubinets")
    public Certificate getCertificateById(long id) {
        return this.certificateDao.getCertificateById(id);
    }

    @Transactional("dubinets")
    public List<Certificate> getCertificates() {
        return this.certificateDao.getCertificates();
    }

    @Transactional("dubinets")
    public void removeCertificate(long id) {
        this.certificateDao.removeCertificate(id);
    }
}
