package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.ocean.animals.dao.PhotoDao;
import ru.ocean.animals.model.Photo;

import java.util.List;

public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoDao photoDao;

    @Transactional("dubinets")
    public void addPhoto(Photo photo) {
        this.photoDao.addPhoto(photo);
    }

    @Transactional("dubinets")
    public void updatePhoto(Photo photo) {
        this.photoDao.updatePhoto(photo);
    }

    @Transactional("dubinets")
    public Photo getPhotoById(long id) {
        return this.photoDao.getPhotoById(id);
    }

    @Transactional("dubinets")
    public List<Photo> getPhotos() {
        return this.photoDao.getPhotos();
    }

    @Transactional("dubinets")
    public void removePhoto(long id) {
        this.photoDao.removePhoto(id);
    }
}
