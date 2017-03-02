package ru.ocean.animals.service;

import ru.ocean.animals.model.Tag;

import java.util.List;

public interface TagService {
    void        addTag(Tag tag);
    void        updateTag(Tag tag);
    Tag         getTagById(long id);
    List<Tag>   getTags();
    void        removeTag(long id);
}
