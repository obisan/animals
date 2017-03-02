package ru.ocean.animals.service;

import ru.ocean.animals.model.Tank;

import java.util.List;

public interface TankService {
    void                addTank(Tank tank);
    void                updateTank(Tank tank);
    Tank                getTankById(long id);
    List<Tank>          getTanks();
    void                removeTank(long id);
}
