package ru.ocean.animals.dao;

import ru.ocean.animals.model.Class;

import java.util.List;

public interface ClassDao {
    void            addClass(Class aClass);
    void            updateClass(Class aClass);
    Class           getClassById(long id);
    List<Class>     getClasses();
    void            removeClass(long id);
}
