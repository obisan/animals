package ru.ocean.animals.dao;

import ru.ocean.animals.model.GroupAllowance;

import java.util.List;

public interface GroupAllowanceDao {
    void                    addGroupAllowance(GroupAllowance groupAllowance);
    void                    updateGroupAllowance(GroupAllowance groupAllowance);
    GroupAllowance          getGroupAllowanceById(long id);
    List<GroupAllowance>    getGroupAllowances();
    void                    removeGroupAllowance(long id);
}
