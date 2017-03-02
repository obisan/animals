package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.TankDao;
import ru.ocean.animals.model.Tank;

import java.util.List;

@Service
public class TankServiceImpl implements TankService {

    @Autowired
    private TankDao tankDao;

    @Transactional("dubinets")
    public void addTank(Tank tank) {
        this.tankDao.addTank(tank);
    }

    @Transactional("dubinets")
    public void updateTank(Tank tank) {
        this.tankDao.updateTank(tank);
    }

    @Transactional("dubinets")
    public Tank getTankById(long id) {
        return this.tankDao.getTankById(id);
    }

    @Transactional("dubinets")
    public List<Tank> getTanks() {
        return this.tankDao.getTanks();
    }

    @Transactional("dubinets")
    public void removeTank(long id) {
        this.tankDao.removeTank(id);
    }
}
