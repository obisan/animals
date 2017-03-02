package ru.ocean.animals.service;

import ru.ocean.animals.model.JournalAllowance;

import java.util.List;

public interface JournalAllowanceService {
    void                    addJournalAllowance(JournalAllowance journalAllowance);
    void                    updateJournalAllowance(JournalAllowance journalAllowance);
    JournalAllowance        getJournalAllowanceById(long id);
    List<JournalAllowance>  getJournalAllowances();
    void                    removeJournalAllowance(long id);
}
