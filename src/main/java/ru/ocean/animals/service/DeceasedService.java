package ru.ocean.animals.service;

import ru.ocean.animals.model.Deceased;
import ru.ocean.animals.model.DeceasedCriteria;

import java.util.List;

public interface DeceasedService {
    void                addDeceased(Deceased deceased);
    void                updateDeceased(Deceased deceased);
    Deceased            getDeceasedById(long id);
    List<Deceased>      getDeceaseds();
    void                removeDeceased(long id);

    List<Deceased>      findDeceased(DeceasedCriteria deceasedCriteria);
}
