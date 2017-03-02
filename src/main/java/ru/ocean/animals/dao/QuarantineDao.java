package ru.ocean.animals.dao;

import ru.ocean.animals.model.Quarantine;

import java.util.List;

public interface QuarantineDao {
    void                addQuarantine(Quarantine quarantine);
    void                updateQuarantine(Quarantine quarantine);
    Quarantine          getQuarantineById(Long id);
    List<Quarantine>    getQuarantines();
    void                removeQuarantine(Long id);
}
