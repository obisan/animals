package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.JournalAllowanceDao;
import ru.ocean.animals.model.JournalAllowance;

import java.util.List;

@Service
public class JournalAllowanceServiceImpl implements JournalAllowanceService {

    @Autowired
    private JournalAllowanceDao journalAllowanceDao;

    @Transactional("dubinets")
    public void addJournalAllowance(JournalAllowance journalAllowance) {
        this.journalAllowanceDao.addJournalAllowance(journalAllowance);
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
}
