package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.DisplacementDao;
import ru.ocean.animals.model.Displacement;

import java.util.List;

@Service
public class DisplacementServiceImpl implements DisplacementService {

    @Autowired
    private DisplacementDao displacementDao;

    @Transactional("dubinets")
    public void addDisplacement(Displacement displacement) {
        this.displacementDao.addDisplacement(displacement);
    }

    @Transactional("dubinets")
    public void updateDisplacement(Displacement displacement) {
        this.displacementDao.updateDisplacement(displacement);
    }

    @Transactional("dubinets")
    public Displacement getDisplacementById(long id) {
        return this.displacementDao.getDisplacementById(id);
    }

    @Transactional("dubinets")
    public List<Displacement> getDisplacements() {
        return this.displacementDao.getDisplacements();
    }

    @Transactional("dubinets")
    public void removeDisplacement(long id) {
        this.displacementDao.removeDisplacement(id);
    }
}
