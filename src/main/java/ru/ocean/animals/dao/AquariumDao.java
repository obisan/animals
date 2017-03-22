package ru.ocean.animals.dao;

import ru.ocean.animals.model.Aquarium;

import java.util.List;

public interface AquariumDao {
    void            addAquarium(Aquarium aquarium);
    void            updateAquarium(Aquarium aquarium);
    Aquarium        getAquariumById(long id);
    List<Aquarium>  getAquariums();
    void            removeAquarium(long id);
}
