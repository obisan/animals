package ru.ocean.animals.dao;

import ru.ocean.animals.model.Condition;

import java.util.List;

public interface ConditionDao {
    void                addCondition(Condition condition);
    void                updateCondition(Condition condition);
    Condition           getConditionById(Long id);
    List<Condition>     getConditions();
    void                removeCondition(Long id);
}
