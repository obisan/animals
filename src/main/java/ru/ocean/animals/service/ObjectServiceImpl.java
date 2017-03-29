package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.LabelDao;
import ru.ocean.animals.dao.ObjectDao;
import ru.ocean.animals.formatter.DateFormatter;
import ru.ocean.animals.formatter.DateFormatterImpl;
import ru.ocean.animals.model.*;
import ru.ocean.animals.model.Object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private ObjectDao objectDao;

    @Autowired
    private LabelDao labelDao;

    private DateFormatter formatter = DateFormatterImpl.getInstance();

    @Transactional("dubinets")
    public void addObject(Object object) {
        this.objectDao.addObject(object);
    }

    @Transactional("dubinets")
    public void addObjectExtended(ObjectExtended object) {
        this.objectDao.addObject(object.getObject());
        this.labelDao.addLabel(object.getLabel());
    }

    @Transactional("dubinets")
    public void updateObject(Object object) {
        this.objectDao.updateObject(object);
    }

    @Transactional("dubinets")
    public void updateObjectExtended(ObjectExtended object) {
        this.objectDao.updateObject(object.getObject());
        this.labelDao.updateLabel(object.getLabel());
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
    public List<Object> getObjectsAliveWithoutParentsBySpecie(long specie_id) {
        return this.objectDao.getObjectsAliveWithoutParentsBySpecie(specie_id);
    }

    @Transactional("dubinets")
    public List<Object> getObjectsAliveWithoutParentsByTank(long tank_id) {
        return this.objectDao.getObjectsAliveWithoutParentsByTank(tank_id);
    }

    @Transactional("dubinets")
    public List<Object> getObjectsAliveWithoutParentsByEmployee(long employee_id) {
        return this.objectDao.getObjectsAliveWithoutParentsByEmployee(employee_id);
    }

    @Transactional("dubinets")
    public List<Object> getObjectsAliveWithoutParentsByDepartment(long department_id) {
        return this.objectDao.getObjectsAliveWithoutParentsByDepartment(department_id);
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
    public List<Quarantine> getQuarantinesOfObject(long id) {
        List<Quarantine> quarantines = new ArrayList<>();

        Object object = this.objectDao.getObjectById(id);
        quarantines.addAll(object.getQuarantines());
        while (true) {
            if(object.getParent_id() == null) break;
            object = this.objectDao.getObjectById(object.getParent_id());
            quarantines.addAll(object.getQuarantines());
        }

        Collections.sort(quarantines, (o1, o2) -> formatter.parse(o1.getQuarantine_date_start()).before(formatter.parse(o2.getQuarantine_date_start())) ? -1 : 1);

        return quarantines;
    }

    @Transactional("dubinets")
    public List<Deceased> getDeceasedsOfObject(long id) {
        List<Deceased> deceaseds = new ArrayList<>();

        Object object = this.objectDao.getObjectById(id);
        while (true) {
            if(object.getParent_id() == null) break;
            object = this.objectDao.getObjectById(object.getParent_id());
            deceaseds.addAll(object.getDeceaseds());
        }

        Collections.sort(deceaseds, (o1, o2) -> formatter.parse(o1.getDeceased_date()).before(formatter.parse(o2.getDeceased_date())) ? -1 : 1);

        return deceaseds;
    }

    @Transactional("dubinets")
    public List<Displacement> getDisplacementsOfObject(long id) {
        List<Displacement> displacements = new ArrayList<>();

        Object object = this.objectDao.getObjectById(id);
        while (true) {
            if(object.getParent_id() == null) break;
            object = this.objectDao.getObjectById(object.getParent_id());
            displacements.addAll(object.getDisplacements());
        }

        Collections.sort(displacements, (o1, o2) -> formatter.parse(o1.getDate_arrival()).before(formatter.parse(o2.getDate_arrival())) ? -1 : 1);

        return displacements;
    }

    @Transactional("dubinets")
    public void removeObject(long id) {
        this.objectDao.removeObject(id);
    }
}
