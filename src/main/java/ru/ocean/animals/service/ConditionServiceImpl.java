package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.ConditionDao;
import ru.ocean.animals.model.Condition;

import java.util.List;

@Service
public class ConditionServiceImpl implements ConditionService {

    @Autowired
    private ConditionDao conditionDao;

    @Transactional("dubinets")
    public void addCondition(Condition condition) {
        this.conditionDao.addCondition(condition);
    }

    @Transactional("dubinets")
    public void updateCondition(Condition condition) {
        this.conditionDao.updateCondition(condition);
    }

    @Transactional("dubinets")
    public Condition getConditionById(long id) {
        return this.conditionDao.getConditionById(id);
    }

    @Transactional("dubinets")
    public List<Condition> getConditions() {
        return this.conditionDao.getConditions();
    }

    @Transactional("dubinets")
    public void removeCondition(long id) {
        this.conditionDao.removeCondition(id);
    }
}
