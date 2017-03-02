package ru.ocean.animals.dao;

import ru.ocean.animals.model.Label;

import java.util.List;

public interface LabelDao {
    void                addLabel(Label label);
    void                updateLabel(Label label);
    Label               getLabelById(Long id);
    List<Label>         getLabels();
    void                removeLabel(Long id);
}
