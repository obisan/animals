package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.AllowanceDao;
import ru.ocean.animals.model.Allowance;

import java.util.List;

@Service
public class AllowanceServiceImpl implements AllowanceService {

    @Autowired
    private AllowanceDao allowanceDao;

    @Transactional("dubinets")
    public void addAllowance(Allowance allowance) {
        this.allowanceDao.addAllowance(allowance);
    }

    @Transactional("dubinets")
    public void updateAllowance(Allowance allowance) {
        this.allowanceDao.updateAllowance(allowance);
    }

    @Transactional("dubinets")
    public Allowance getAllowanceById(long id) {
        return this.allowanceDao.getAllowanceById(id);
    }

    @Transactional("dubinets")
    public List<Allowance> getAllowances() {
        return this.allowanceDao.getAllowances();
    }

    @Transactional("dubinets")
    public void removeAllowance(long id) {
        this.allowanceDao.removeAllowance(id);
    }
}
