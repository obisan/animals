package ru.ocean.animals.service;

import ru.ocean.animals.model.Specie;

import java.util.List;

public interface SpecieService {
    void            addSpecie(Specie specie);
    void            updateSpecie(Specie specie);
    Specie          getSpecieById(long id);
    List<Specie>    getSpecies();
    void            removeSpecie(long id);
}
