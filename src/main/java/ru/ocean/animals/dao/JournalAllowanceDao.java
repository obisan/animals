package ru.ocean.animals.dao;

import ru.ocean.animals.model.JournalAllowance;

import java.util.List;

public interface JournalAllowanceDao {
    void                    addJournalAllowance(JournalAllowance journalAllowance);
    void                    updateJournalAllowance(JournalAllowance journalAllowance);
    JournalAllowance        getJournalAllowanceById(long id);
    List<JournalAllowance>  getJournalAllowances();
    void                    removeJournalAllowance(long id);
}
