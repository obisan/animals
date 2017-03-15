package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.SpecieDao;
import ru.ocean.animals.dao.TagDao;
import ru.ocean.animals.model.Specie;
import ru.ocean.animals.model.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SpecieServiceImpl implements SpecieService {

    @Autowired
    private SpecieDao specieDao;

    @Autowired
    private TagDao tagDao;

    @Transactional("dubinets")
    public void addSpecie(Specie specie) {
        Set<Tag> tags = new HashSet<>();
        for(String str : specie.getTags2()) {
            tags.add(tagDao.getTagBySysString(str));
        }
        specie.setTags(tags);

        this.specieDao.addSpecie(specie);
    }

    @Transactional("dubinets")
    public void updateSpecie(Specie specie) {
        Set<Tag> tags = new HashSet<>();
        for(String str : specie.getTags2()) {
            tags.add(tagDao.getTagBySysString(str));
        }
        specie.setTags(tags);

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
