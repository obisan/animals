package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.TagDao;
import ru.ocean.animals.model.Tag;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Transactional("dubinets")
    public void addTag(Tag tag) {
        this.tagDao.addTag(tag);
    }

    @Transactional("dubinets")
    public void updateTag(Tag tag) {
        this.tagDao.updateTag(tag);
    }

    @Transactional("dubinets")
    public Tag getTagById(long id) {
        return this.tagDao.getTagById(id);
    }

    @Transactional("dubinets")
    public List<Tag> getTags() {
        return this.tagDao.getTags();
    }

    @Transactional("dubinets")
    public void removeTag(long id) {
        this.tagDao.removeTag(id);
    }
}
