package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.DeceasedDao;
import ru.ocean.animals.dao.ObjectDao;
import ru.ocean.animals.model.Deceased;
import ru.ocean.animals.model.DeceasedCriteria;
import ru.ocean.animals.model.Object;

import java.util.List;

@Service
public class DeceasedServiceImpl implements DeceasedService {

    @Autowired
    private DeceasedDao deceasedDao;

    @Autowired
    private ObjectDao objectDao;

    @Transactional("dubinets")
    public void addDeceased(Deceased deceased) {
        Object object = this.objectDao.getObjectById(deceased.getObject_id());
        object.decrease(deceased.getDeceased_count());
        this.objectDao.updateObject(object);

        // Установить номер танка где умерла рыба
        deceased.setTank_id(object.getTank_id());
        deceased.setAquarium_id(object.getAquarium_id());
        this.deceasedDao.addDeceased(deceased);
    }

    @Transactional("dubinets")
    public void updateDeceased(Deceased deceased) {
        this.deceasedDao.updateDeceased(deceased);
    }

    @Transactional("dubinets")
    public Deceased getDeceasedById(long id) {
        return this.deceasedDao.getDeceasedById(id);
    }

    @Transactional("dubinets")
    public List<Deceased> getDeceaseds() {
        return this.deceasedDao.getDeceaseds();
    }

    @Transactional("dubinets")
    public void removeDeceased(long id) {
        Deceased deceased = this.getDeceasedById(id);
        Object object = this.objectDao.getObjectById(deceased.getObject_id());
        object.increase(deceased.getDeceased_count());
        this.objectDao.updateObject(object);

        this.deceasedDao.removeDeceased(id);
    }

    @Override
    public List<Deceased> findDeceased(DeceasedCriteria deceasedCriteria) {
        return this.deceasedDao.findDeceased(deceasedCriteria);
    }
}
