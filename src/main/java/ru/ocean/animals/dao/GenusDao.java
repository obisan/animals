package ru.ocean.animals.dao;

import ru.ocean.animals.model.Genus;

import java.util.List;

public interface GenusDao {
    void            addGenus(Genus genus);
    void            updateGenus(Genus genus);
    Genus           getGenusById(Long id);
    List<Genus>     getGenuses();
    void            removeGenus(Long id);
}
