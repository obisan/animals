package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.AllowanceDao;
import ru.ocean.animals.dao.JournalAllowanceDao;
import ru.ocean.animals.dao.ObjectDao;
import ru.ocean.animals.model.Allowance;
import ru.ocean.animals.model.JournalAllowance;
import ru.ocean.animals.model.JournalAllowanceExtended;
import ru.ocean.animals.model.Object;

import java.util.ArrayList;
import java.util.List;

@Service
public class JournalAllowanceServiceImpl implements JournalAllowanceService {

    @Autowired
    private JournalAllowanceDao journalAllowanceDao;

    @Autowired
    private ObjectDao           objectDao;

    @Autowired
    private AllowanceDao        allowanceDao;

    @Transactional("dubinets")
    public void addJournalAllowance(JournalAllowance journalAllowance) {
        this.journalAllowanceDao.addJournalAllowance(journalAllowance);
    }

    @Transactional("dubinets")
    public void addJournalAllowanceGroup(JournalAllowanceExtended journalAllowanceExtended) {

        List<Object> objects = new ArrayList<>();

        if(journalAllowanceExtended.getObject1_id() != null)
            objects.add(objectDao.getObjectById(journalAllowanceExtended.getObject1_id()));
        if(journalAllowanceExtended.getObject2_id() != null)
            objects.add(objectDao.getObjectById(journalAllowanceExtended.getObject2_id()));
        if(journalAllowanceExtended.getObject3_id() != null)
            objects.add(objectDao.getObjectById(journalAllowanceExtended.getObject3_id()));
        if(journalAllowanceExtended.getObject4_id() != null)
            objects.add(objectDao.getObjectById(journalAllowanceExtended.getObject4_id()));
        if(journalAllowanceExtended.getObject5_id() != null)
            objects.add(objectDao.getObjectById(journalAllowanceExtended.getObject5_id()));
        if(journalAllowanceExtended.getObject6_id() != null)
            objects.add(objectDao.getObjectById(journalAllowanceExtended.getObject6_id()));
        if(journalAllowanceExtended.getObject7_id() != null)
            objects.add(objectDao.getObjectById(journalAllowanceExtended.getObject7_id()));
        if(journalAllowanceExtended.getObject8_id() != null)
            objects.add(objectDao.getObjectById(journalAllowanceExtended.getObject8_id()));
        if(journalAllowanceExtended.getObject9_id() != null)
            objects.add(objectDao.getObjectById(journalAllowanceExtended.getObject9_id()));
        if(journalAllowanceExtended.getObject10_id() != null)
            objects.add(objectDao.getObjectById(journalAllowanceExtended.getObject10_id()));

        List<Pair<Allowance, Float>> allowances = new ArrayList<>();
        if(journalAllowanceExtended.getAllowance1_id() != null)
            allowances.add(
                    new Pair<>(
                            allowanceDao.getAllowanceById(journalAllowanceExtended.getAllowance1_id()),
                            journalAllowanceExtended.getWeight1()
                    )
            );

        if(journalAllowanceExtended.getAllowance2_id() != null)
            allowances.add(
                    new Pair<>(
                            allowanceDao.getAllowanceById(journalAllowanceExtended.getAllowance2_id()),
                            journalAllowanceExtended.getWeight2()
                    )
            );

        if(journalAllowanceExtended.getAllowance3_id() != null)
            allowances.add(
                    new Pair<>(
                            allowanceDao.getAllowanceById(journalAllowanceExtended.getAllowance3_id()),
                            journalAllowanceExtended.getWeight3()
                    )
            );

        if(journalAllowanceExtended.getAllowance4_id() != null)
            allowances.add(
                    new Pair<>(
                            allowanceDao.getAllowanceById(journalAllowanceExtended.getAllowance4_id()),
                            journalAllowanceExtended.getWeight4()
                    )
            );

        if(journalAllowanceExtended.getAllowance5_id() != null)
            allowances.add(
                    new Pair<>(
                            allowanceDao.getAllowanceById(journalAllowanceExtended.getAllowance5_id()),
                            journalAllowanceExtended.getWeight5()
                    )
            );

        if(journalAllowanceExtended.getAllowance6_id() != null)
            allowances.add(
                    new Pair<>(
                            allowanceDao.getAllowanceById(journalAllowanceExtended.getAllowance6_id()),
                            journalAllowanceExtended.getWeight5()
                    )
            );

        if(journalAllowanceExtended.getAllowance7_id() != null)
            allowances.add(
                    new Pair<>(
                            allowanceDao.getAllowanceById(journalAllowanceExtended.getAllowance7_id()),
                            journalAllowanceExtended.getWeight5()
                    )
            );

        if(journalAllowanceExtended.getAllowance8_id() != null)
            allowances.add(
                    new Pair<>(
                            allowanceDao.getAllowanceById(journalAllowanceExtended.getAllowance8_id()),
                            journalAllowanceExtended.getWeight5()
                    )
            );

        if(journalAllowanceExtended.getAllowance9_id() != null)
            allowances.add(
                    new Pair<>(
                            allowanceDao.getAllowanceById(journalAllowanceExtended.getAllowance9_id()),
                            journalAllowanceExtended.getWeight5()
                    )
            );

        if(journalAllowanceExtended.getAllowance10_id() != null)
            allowances.add(
                    new Pair<>(
                            allowanceDao.getAllowanceById(journalAllowanceExtended.getAllowance10_id()),
                            journalAllowanceExtended.getWeight5()
                    )
            );

        for(Object object : objects) {
            for (Pair<Allowance, Float> pair : allowances) {
                JournalAllowance journalAllowance = new JournalAllowance();
                journalAllowance.setObject_id(object.getId());
                journalAllowance.setAllowance_id(pair.getL().getId());
                journalAllowance.setWeight(pair.getR());
                journalAllowanceDao.addJournalAllowance(journalAllowance);
            }
        }
    }

    @Transactional("dubinets")
    public void updateJournalAllowance(JournalAllowance journalAllowance) {
        this.journalAllowanceDao.updateJournalAllowance(journalAllowance);
    }

    @Transactional("dubinets")
    public JournalAllowance getJournalAllowanceById(long id) {
        return this.journalAllowanceDao.getJournalAllowanceById(id);
    }

    @Transactional("dubinets")
    public List<JournalAllowance> getJournalAllowances() {
        return this.journalAllowanceDao.getJournalAllowances();
    }

    @Transactional("dubinets")
    public void removeJournalAllowance(long id) {
        this.journalAllowanceDao.removeJournalAllowance(id);
    }

    private class Pair<L,R> {
        private L l;
        private R r;
        public Pair(L l, R r){
            this.l = l;
            this.r = r;
        }
        public L getL(){ return l; }
        public R getR(){ return r; }
        public void setL(L l){ this.l = l; }
        public void setR(R r){ this.r = r; }
    }
}
