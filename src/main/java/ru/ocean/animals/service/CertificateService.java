package ru.ocean.animals.service;

import ru.ocean.animals.model.Certificate;

import java.util.List;

public interface CertificateService {
    void                addCertificate(Certificate certificate);
    void                updateCertificate(Certificate certificate);
    Certificate         getCertificateById(long id);
    List<Certificate>   getCertificates();
    void                removeCertificate(long id);
}
