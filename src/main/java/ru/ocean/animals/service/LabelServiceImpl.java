package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.LabelDao;
import ru.ocean.animals.model.Label;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;

    @Transactional("dubinets")
    public void addLabel(Label label) {
        this.labelDao.addLabel(label);
    }

    @Transactional("dubinets")
    public void updateLabel(Label label) {
        this.labelDao.updateLabel(label);
    }

    @Transactional("dubinets")
    public Label getLabelById(long id) {
        return this.labelDao.getLabelById(id);
    }

    @Transactional("dubinets")
    public List<Label> getLabels() {
        return this.labelDao.getLabels();
    }

    @Transactional("dubinets")
    public void removeLabel(long id) {
        this.labelDao.removeLabel(id);
    }
}
