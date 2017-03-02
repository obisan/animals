package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.ClassDao;
import ru.ocean.animals.model.Class;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Transactional("dubinets")
    public void addClass(Class aClass) {
        this.classDao.addClass(aClass);
    }

    @Transactional("dubinets")
    public void updateClass(Class aClass) {
        this.classDao.updateClass(aClass);
    }

    @Transactional("dubinets")
    public Class getClassById(long id) {
        return this.classDao.getClassById(id);
    }

    @Transactional("dubinets")
    public List<Class> getClasses() {
        return this.classDao.getClasses();
    }

    @Transactional("dubinets")
    public void removeClass(long id) {
        this.classDao.removeClass(id);
    }
}
