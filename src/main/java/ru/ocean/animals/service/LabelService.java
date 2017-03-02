package ru.ocean.animals.service;

import ru.ocean.animals.model.Label;

import java.util.List;

public interface LabelService {
    void                addLabel(Label label);
    void                updateLabel(Label label);
    Label               getLabelById(long id);
    List<Label>         getLabels();
    void                removeLabel(long id);
}
