package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.QuarantineDao;
import ru.ocean.animals.model.Quarantine;

import java.util.List;

@Service
public class QuarantineServiceImpl implements QuarantineService {

    @Autowired
    private QuarantineDao quarantineDao;

    @Transactional("dubinets")
    public void addQuarantine(Quarantine quarantine) {
        this.quarantineDao.addQuarantine(quarantine);
    }

    @Transactional("dubinets")
    public void updateQuarantine(Quarantine quarantine) {
        this.quarantineDao.updateQuarantine(quarantine);
    }

    @Transactional("dubinets")
    public Quarantine getQuarantineById(long id) {
        return this.quarantineDao.getQuarantineById(id);
    }

    @Transactional("dubinets")
    public List<Quarantine> getQuarantines() {
        return this.quarantineDao.getQuarantines();
    }

    @Transactional("dubinets")
    public void removeQuarantine(long id) {
        this.quarantineDao.removeQuarantine(id);
    }
}
