package ru.ocean.animals.dao;

import ru.ocean.animals.model.Photo;

import java.util.List;

public interface PhotoDao {
    void            addPhoto(Photo photo);
    void            updatePhoto(Photo photo);
    Photo           getPhotoById(long id);
    List<Photo>     getPhotos();
    void            removePhoto(long id);
}
