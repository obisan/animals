package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.SpecieDao;
import ru.ocean.animals.model.Specie;

import java.util.List;

@Service
public class SpecieServiceImpl implements SpecieService {

    @Autowired
    private SpecieDao specieDao;

    @Transactional("dubinets")
    public void addSpecie(Specie specie) {
        this.specieDao.addSpecie(specie);
    }

    @Transactional("dubinets")
    public void updateSpecie(Specie specie) {
        this.specieDao.updateSpecie(specie);
    }

    @Transactional("dubinets")
    public Specie getSpecieById(long id) {
        return this.specieDao.getSpecieById(id);
    }

    @Transactional("dubinets")
    public List<Specie> getSpecies() {
        return this.specieDao.getSpecies();
    }

    @Transactional("dubinets")
    public void removeSpecie(long id) {
        this.specieDao.removeSpecie(id);
    }
}
