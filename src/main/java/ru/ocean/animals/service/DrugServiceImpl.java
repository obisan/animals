package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.DrugDao;
import ru.ocean.animals.model.Drug;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugDao drugDao;

    @Transactional("dubinets")
    public void addDrug(Drug drug) {
        this.drugDao.addDrug(drug);
    }

    @Transactional("dubinets")
    public void updateDrug(Drug drug) {
        this.drugDao.updateDrug(drug);
    }

    @Transactional("dubinets")
    public Drug getDrugById(long id) {
        return this.drugDao.getDrugById(id);
    }

    @Transactional("dubinets")
    public List<Drug> getDrugs() {
        return this.drugDao.getDrugs();
    }

    @Transactional("dubinets")
    public void removeDrug(long id) {
        this.drugDao.removeDrug(id);
    }
}
