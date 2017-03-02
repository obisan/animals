package ru.ocean.animals.service;

import ru.ocean.animals.model.Quarantine;

import java.util.List;

public interface QuarantineService {
    void                addQuarantine(Quarantine quarantine);
    void                updateQuarantine(Quarantine quarantine);
    Quarantine          getQuarantineById(long id);
    List<Quarantine>    getQuarantines();
    void                removeQuarantine(long id);
}
