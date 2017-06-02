package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.GroupAllowanceDao;
import ru.ocean.animals.model.GroupAllowance;

import java.util.List;

@Service
public class GroupAllowanceServiceImpl implements GroupAllowanceService {

    @Autowired
    private GroupAllowanceDao groupAllowanceDao;

    @Transactional("dubinets")
    public void addGroupAllowance(GroupAllowance groupAllowance) {
        this.groupAllowanceDao.addGroupAllowance(groupAllowance);
    }

    @Transactional("dubinets")
    public void updateGroupAllowance(GroupAllowance groupAllowance) {
        this.groupAllowanceDao.updateGroupAllowance(groupAllowance);
    }

    @Transactional("dubinets")
    public GroupAllowance getGroupAllowanceById(long id) {
        return this.groupAllowanceDao.getGroupAllowanceById(id);
    }

    @Transactional("dubinets")
    public List<GroupAllowance> getGroupAllowances() {
        return this.groupAllowanceDao.getGroupAllowances();
    }

    @Override
    public void removeGroupAllowance(long id) {
        this.groupAllowanceDao.removeGroupAllowance(id);
    }
}
