package ru.ocean.animals.service;

import ru.ocean.animals.model.JournalAllowance;
import ru.ocean.animals.model.JournalAllowanceExtended;

import java.util.List;

public interface JournalAllowanceService {
    void                    addJournalAllowance(JournalAllowance journalAllowance);
    void                    addJournalAllowanceGroup(JournalAllowanceExtended journalAllowanceExtended);
    void                    updateJournalAllowance(JournalAllowance journalAllowance);
    JournalAllowance        getJournalAllowanceById(long id);
    List<JournalAllowance>  getJournalAllowances();
    void                    removeJournalAllowance(long id);
}
