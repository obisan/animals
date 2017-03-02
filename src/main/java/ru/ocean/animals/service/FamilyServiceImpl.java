package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.FamilyDao;
import ru.ocean.animals.model.Family;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyDao familyDao;

    @Transactional("dubinets")
    public void addFamily(Family family) {
        this.familyDao.addFamily(family);
    }

    @Transactional("dubinets")
    public void updateFamily(Family family) {
        this.familyDao.updateFamily(family);
    }

    @Transactional("dubinets")
    public Family getFamilyById(long id) {
        return this.familyDao.getFamilyById(id);
    }

    @Transactional("dubinets")
    public List<Family> getFamilies() {
        return this.familyDao.getFamilies();
    }

    @Transactional("dubinets")
    public void removeFamily(long id) {
        this.familyDao.removeFamily(id);
    }
}
