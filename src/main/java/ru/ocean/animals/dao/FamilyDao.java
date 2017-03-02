package ru.ocean.animals.dao;

import ru.ocean.animals.model.Family;

import java.util.List;

public interface FamilyDao {
    void            addFamily(Family family);
    void            updateFamily(Family family);
    Family          getFamilyById(Long id);
    List<Family>    getFamilies();
    void            removeFamily(Long id);

}
