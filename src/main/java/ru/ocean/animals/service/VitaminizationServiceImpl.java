package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.DrugDao;
import ru.ocean.animals.dao.VitaminizationDao;
import ru.ocean.animals.model.Drug;
import ru.ocean.animals.model.Vitaminization;
import ru.ocean.animals.model.VitaminizationExtended;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VitaminizationServiceImpl implements VitaminizationService {

    @Autowired
    private VitaminizationDao vitaminizationDao;

    @Autowired
    private DrugDao drugDao;

    @Transactional("dubinets")
    public void addVitaminization(Vitaminization vitaminization, List<Drug> drugs) {
        Set<Drug> drugSet = new HashSet<>();

        for(Drug drug : drugs) {
            if(drug.getId() != null) {
                drugSet.add(drugDao.getDrugById(drug.getId()));
            }
        }

        vitaminization.setDrugs(drugSet);

        this.vitaminizationDao.addVitaminization(vitaminization);
    }

    @Transactional("dubinets")
    public void updateVitaminization(Vitaminization vitaminization, List<Drug> drugs) {
        //this.vitaminizationDao.updateVitaminization(vitaminization);
    }

    @Transactional("dubinets")
    public Vitaminization getVitaminizationById(long id) {
        return this.vitaminizationDao.getVitaminizationById(id);
    }

    @Transactional("dubinets")
    public VitaminizationExtended getVitaminizationExtendedById(long id) {
        VitaminizationExtended vitaminizationExtended = new VitaminizationExtended();
        vitaminizationExtended.setVitaminization(
                this.vitaminizationDao.getVitaminizationById(id)
        );

        Set<Drug> drugs = vitaminizationExtended.getVitaminization().getDrugs();

        if(drugs.size() >= 1) {
            vitaminizationExtended.setDrug1(((Drug) drugs.toArray()[0]));
        }
        if(drugs.size() >= 2) {
            vitaminizationExtended.setDrug2(((Drug) drugs.toArray()[1]));
        }
        if(drugs.size() >= 3) {
            vitaminizationExtended.setDrug3(((Drug) drugs.toArray()[2]));
        }
        if(drugs.size() == 4) {
            vitaminizationExtended.setDrug4(((Drug) drugs.toArray()[3]));
        }
        if(drugs.size() >= 5) {
            vitaminizationExtended.setDrug5(((Drug) drugs.toArray()[4]));
        }
        if(drugs.size() >= 6) {
            vitaminizationExtended.setDrug6(((Drug) drugs.toArray()[5]));
        }
        if(drugs.size() >= 7) {
            vitaminizationExtended.setDrug7(((Drug) drugs.toArray()[6]));
        }
        if(drugs.size() == 8) {
            vitaminizationExtended.setDrug8(((Drug) drugs.toArray()[7]));
        }
        if(drugs.size() >= 9) {
            vitaminizationExtended.setDrug9(((Drug) drugs.toArray()[8]));
        }
        if(drugs.size() == 10) {
            vitaminizationExtended.setDrug10(((Drug) drugs.toArray()[9]));
        }

        return vitaminizationExtended;
    }

    @Transactional("dubinets")
    public List<Vitaminization> getVitaminizations() {
        return this.vitaminizationDao.getVitaminizations();
    }

    @Transactional("dubinets")
    public void removeVitaminization(long id) {
        this.vitaminizationDao.removeVitaminization(id);
    }
}
