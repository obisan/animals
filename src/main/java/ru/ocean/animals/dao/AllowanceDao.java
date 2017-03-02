package ru.ocean.animals.dao;

import ru.ocean.animals.model.Allowance;

import java.util.List;

public interface AllowanceDao {
    void                addAllowance(Allowance allowance);
    void                updateAllowance(Allowance allowance);
    Allowance           getAllowanceById(long id);
    List<Allowance>     getAllowances();
    void                removeAllowance(long id);
}
