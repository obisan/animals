package ru.ocean.animals.dao;

import ru.ocean.animals.model.Certificate;

import java.util.List;

public interface CertificateDao {
    void                    addCertificate(Certificate certificate);
    void                    updateCertificate(Certificate certificate);
    Certificate             getCertificateById(Long id);
    List<Certificate>       getCertificates();
    void                    removeCertificate(Long id);
}
