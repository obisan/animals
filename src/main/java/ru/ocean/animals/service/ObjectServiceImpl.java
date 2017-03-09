package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.DeceasedDao;
import ru.ocean.animals.dao.DisplacementDao;
import ru.ocean.animals.dao.ObjectDao;
import ru.ocean.animals.dao.QuarantineDao;
import ru.ocean.animals.model.*;
import ru.ocean.animals.model.Object;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private ObjectDao objectDao;

    @Autowired
    private DisplacementDao displacementDao;

    @Autowired
    private QuarantineDao quarantineDao;

    @Autowired
    private DeceasedDao deceasedDao;

    @Transactional("dubinets")
    public void addObject(Object object) {
        this.objectDao.addObject(object);
    }

    @Transactional("dubinets")
    public void updateObject(Object object) {
        this.objectDao.updateObject(object);
    }

    @Transactional("dubinets")
    public Object splitObject(long object_id, int count) {
        Object object   = this.objectDao.getObjectById(object_id);

        Object object2 = new Object();
        object2.setObject_name(object.getObject_name());
        object2.setObject_length(object.getObject_length());
        object2.setObject_weight(object.getObject_weight());
        object2.setObject_count(count);
        object2.setSpecie_id(object.getSpecie_id());
        object2.setEmployee_id(object.getEmployee_id());
        object2.setLabel_id(object.getLabel_id());

        this.objectDao.addObject(object2);

        try {
            for(Displacement displacement : object.getDisplacements()) {
                Displacement displacement2 = displacement.clone();
                displacement2.setObject_id(object2.getId());
                displacementDao.addDisplacement(displacement);
                object2.getDisplacements().add(displacement);
            }

            for(Quarantine quarantine : object.getQuarantines()) {
                Quarantine quarantine2 = quarantine.clone();
                quarantine2.setObject_id(object2.getId());
                quarantineDao.addQuarantine(quarantine2);
                object2.getQuarantines().add(quarantine2);
            }

            for(Deceased deceased : object.getDeceaseds()) {
                Deceased deceased2 = deceased.clone();
                deceased2.setObject_id(object2.getId());
                deceasedDao.addDeceased(deceased);
                object2.getDeceaseds().add(deceased2);
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        this.objectDao.updateObject(object2);

        object.decrease(count);
        this.objectDao.updateObject(object);

        return object2;
    }

    @Transactional("dubinets")
    public List<Object> splitObject2(Object parent, int count, long tank_target) {
        Object child1 = null;
        Object child2 = null;

        List<Object> objects = new ArrayList<>();
        try {
            child1 = parent.clone();
            child2 = parent.clone();

            child1.setObject_count(parent.getObject_count() - count);
            child1.setParent_id(parent.getId());

            child2.setObject_count(count);
            child2.setTank_id(tank_target);
            child2.setParent_id(parent.getId());

            this.objectDao.addObject(child1);
            this.objectDao.addObject(child2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        objects.add(child1);
        objects.add(child2);

        return objects;
    }

    @Transactional("dubinets")
    public Object getObjectById(long id) {
        return this.objectDao.getObjectById(id);
    }

    @Transactional("dubinets")
    public List<Object> getObjectsAlive() {
        return this.objectDao.getObjectsAlive();
    }

    @Transactional("dubinets")
    public List<Object> getObjectsAliveWithoutParents() {
        return this.objectDao.getObjectsAliveWithoutParents();
    }

    @Transactional("dubinets")
    public List<Object> getObjectsWithDeads() {
        return this.objectDao.getObjectsWithDeads();
    }

    @Transactional("dubinets")
    public List<Object> getObjectsFilteredBySpecieId(long specie_id) {
        return this.objectDao.getObjectsFilteredBySpecieId(specie_id);
    }

    @Transactional("dubinets")
    public void removeObject(long id) {
        this.objectDao.removeObject(id);
    }
}
