package ru.ocean.animals.dao;

import ru.ocean.animals.model.Tag;

import java.util.List;

public interface TagDao {
    void        addTag(Tag tag);
    void        updateTag(Tag tag);
    Tag         getTagById(long id);
    Tag         getTagBySysString(String str);
    List<Tag>   getTags();
    void        removeTag(long id);
}
