package ru.ocean.animals.service;

import ru.ocean.animals.model.Condition;

import java.util.List;

public interface ConditionService {
    void                addCondition(Condition condition);
    void                updateCondition(Condition condition);
    Condition           getConditionById(long id);
    List<Condition>     getConditions();
    void                removeCondition(long id);
}
