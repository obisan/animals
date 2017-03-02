package ru.ocean.animals.dao;

import ru.ocean.animals.model.Specie;

import java.util.List;

public interface SpecieDao {
    void            addSpecie(Specie specie);
    void            updateSpecie(Specie specie);
    Specie          getSpecieById(Long id);
    List<Specie>    getSpecies();
    void            removeSpecie(Long id);

}
