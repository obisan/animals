package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.*;
import ru.ocean.animals.model.*;
import ru.ocean.animals.model.Object;

import java.util.*;

@Service
public class VitaminizationServiceImpl implements VitaminizationService {

    @Autowired
    private VitaminizationDao vitaminizationDao;

    @Autowired
    private ObjectDao objectDao;

    @Autowired
    private DrugDao drugDao;

    @Autowired
    private TankDao tankDao;

    @Autowired
    private AquariumDao aquariumDao;

    @Transactional("dubinets")
    public void addVitaminization(VitaminizationExtended vitaminization_ext) {
        Set<Drug> drugs = new HashSet<>();
        drugs.add(vitaminization_ext.getDrug1()); drugs.add(vitaminization_ext.getDrug2());
        drugs.add(vitaminization_ext.getDrug3()); drugs.add(vitaminization_ext.getDrug4());
        drugs.add(vitaminization_ext.getDrug5()); drugs.add(vitaminization_ext.getDrug6());
        drugs.add(vitaminization_ext.getDrug7()); drugs.add(vitaminization_ext.getDrug8());
        drugs.add(vitaminization_ext.getDrug9()); drugs.add(vitaminization_ext.getDrug10());

        if(vitaminization_ext.getTank().getId() != null) {
            Tank tank = tankDao.getTankById(vitaminization_ext.getTank().getId());

            List<Object> objects = new ArrayList<>();
            if(vitaminization_ext.getAquariums() != null) {
                List<Aquarium> aquariums = new ArrayList<>();
                for(Long aquarium_id : vitaminization_ext.getAquariums()) {
                    aquariums.add(aquariumDao.getAquariumById(aquarium_id));
                }

                for(Aquarium aquarium : aquariums) {
                    objects.addAll(objectDao.getObjectsAliveWithoutParentsByTankAndAquarium(tank.getId(), aquarium.getId()));
                }
            } else {
                objects.addAll(tank.getObjects());
            }


            for(Object object : objects) {
                Vitaminization vitaminization = new Vitaminization();
                vitaminization.setVitaminization_date(vitaminization_ext.getVitaminization().getVitaminization_date());
                vitaminization.setObject_id(object.getId());

                Set<Drug> drugs_loaded = new HashSet<>();
                for(Drug drug : drugs) {
                    if(drug.getId() != null) {
                        drugs_loaded.add(drugDao.getDrugById(drug.getId()));
                    }
                }
                vitaminization.setDrugs(drugs_loaded);
                this.vitaminizationDao.addVitaminization(vitaminization);
            }

        } else {
            Set<Drug> drugs_loaded = new HashSet<>();
            for(Drug drug : drugs) {
                if(drug.getId() != null) {
                    drugs_loaded.add(drugDao.getDrugById(drug.getId()));
                }
            }

            vitaminization_ext.getVitaminization().setDrugs(drugs_loaded);
            this.vitaminizationDao.addVitaminization(vitaminization_ext.getVitaminization());
        }
    }

    @Transactional("dubinets")
    public void updateVitaminization(VitaminizationExtended vitaminization) {
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
        if(drugs.size() >= 4) {
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
        if(drugs.size() >= 8) {
            vitaminizationExtended.setDrug8(((Drug) drugs.toArray()[7]));
        }
        if(drugs.size() >= 9) {
            vitaminizationExtended.setDrug9(((Drug) drugs.toArray()[8]));
        }
        if(drugs.size() >= 10) {
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
