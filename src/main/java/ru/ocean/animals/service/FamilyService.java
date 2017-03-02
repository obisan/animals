package ru.ocean.animals.service;

import ru.ocean.animals.model.Family;

import java.util.List;

public interface FamilyService {
    void            addFamily(Family family);
    void            updateFamily(Family family);
    Family          getFamilyById(long id);
    List<Family>    getFamilies();
    void            removeFamily(long id);
}
