package ru.ocean.animals.service;

import ru.ocean.animals.model.Allowance;

import java.util.List;

public interface AllowanceService {
    void                addAllowance(Allowance allowance);
    void                updateAllowance(Allowance allowance);
    Allowance           getAllowanceById(long id);
    List<Allowance>     getAllowances();
    void                removeAllowance(long id);
}
