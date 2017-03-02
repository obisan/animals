package ru.ocean.animals.service;

import ru.ocean.animals.model.Genus;

import java.util.List;

public interface GenusService {
    void            addGenus(Genus genus);
    void            updateGenus(Genus genus);
    Genus           getGenusById(long id);
    List<Genus>     getGenuses();
    void            removeGenus(long id);
}
