package ru.ocean.animals.service;

import ru.ocean.animals.model.Aquarium;

import java.util.List;

public interface AquariumService {
    void                addAquarium(Aquarium aquarium);
    void                updateAquarium(Aquarium aquarium);
    Aquarium            getAquariumById(long id);
    List<Aquarium>      getAquariums();
    void                removeAquarium(long id);
}
