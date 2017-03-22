package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ocean.animals.dao.AquariumDao;
import ru.ocean.animals.model.Aquarium;

import java.util.List;

@Service
public class AquariumServiceImpl implements AquariumService {

    @Autowired
    private AquariumDao aquariumDao;

    @Override
    public void addAquarium(Aquarium aquarium) {
        this.aquariumDao.addAquarium(aquarium);
    }

    @Override
    public void updateAquarium(Aquarium aquarium) {
        this.aquariumDao.updateAquarium(aquarium);
    }

    @Override
    public Aquarium getAquariumById(long id) {
        return this.aquariumDao.getAquariumById(id);
    }

    @Override
    public List<Aquarium> getAquariums() {
        return this.aquariumDao.getAquariums();
    }

    @Override
    public void removeAquarium(long id) {
        this.aquariumDao.removeAquarium(id);
    }
}
