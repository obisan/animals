package ru.ocean.animals.dao;

import ru.ocean.animals.model.Deceased;
import ru.ocean.animals.model.DeceasedCriteria;

import java.util.List;

public interface DeceasedDao {
    void            addDeceased(Deceased deceased);
    void            updateDeceased(Deceased deceased);
    Deceased        getDeceasedById(Long id);
    List<Deceased>  getDeceaseds();
    void            removeDeceased(Long id);

    List findDeceased(DeceasedCriteria deceasedCriteria);
}
