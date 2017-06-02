package ru.ocean.animals.service;

import ru.ocean.animals.model.GroupAllowance;

import java.util.List;

public interface GroupAllowanceService {
    void                    addGroupAllowance(GroupAllowance groupAllowance);
    void                    updateGroupAllowance(GroupAllowance groupAllowance);
    GroupAllowance          getGroupAllowanceById(long id);
    List<GroupAllowance>    getGroupAllowances();
    void                    removeGroupAllowance(long id);
}
