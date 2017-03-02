package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.GenusDao;
import ru.ocean.animals.model.Genus;

import java.util.List;

@Service
public class GenusServiceImpl implements GenusService {

    @Autowired
    private GenusDao genusDao;

    @Transactional("dubinets")
    public void addGenus(Genus genus) {
        this.genusDao.addGenus(genus);
    }

    @Transactional("dubinets")
    public void updateGenus(Genus genus) {
        this.genusDao.updateGenus(genus);
    }

    @Transactional("dubinets")
    public Genus getGenusById(long id) {
        return this.genusDao.getGenusById(id);
    }

    @Transactional("dubinets")
    public List<Genus> getGenuses() {
        return this.genusDao.getGenuses();
    }

    @Transactional("dubinets")
    public void removeGenus(long id) {
        this.genusDao.removeGenus(id);
    }
}
