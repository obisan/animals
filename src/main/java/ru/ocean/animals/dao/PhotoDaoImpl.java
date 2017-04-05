package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ocean.animals.model.Photo;

import java.util.List;

public class PhotoDaoImpl implements PhotoDao {
    private static final Logger logger = LoggerFactory.getLogger(PhotoDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPhoto(Photo photo) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(photo);
        logger.info("Photo successfully added. Photo details: " + photo);
    }

    @Override
    public void updatePhoto(Photo photo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(photo);
        logger.info("Photo successfully updated. Photo details: " + photo);
    }

    @Override
    public Photo getPhotoById(long id) {
        Session session = sessionFactory.getCurrentSession();

        Photo photo = (Photo) session.load(Photo.class, new Long(id));
        logger.info("Photo successfully loaded. Photo details: " + photo);
        return photo;
    }

    @SuppressWarnings("unckecked")
    public List<Photo> getPhotos() {
        Session session = sessionFactory.getCurrentSession();

        List<Photo> photos = session.createQuery("from Photo").list();
        logger.info("Photo list successfully loaded. Photo details: " + photos);
        return photos;
    }

    @Override
    public void removePhoto(long id) {
        Session session = sessionFactory.getCurrentSession();

        Photo photo = (Photo) session.load(Photo.class, new Long(id));
        if(photo != null) {
            session.delete(photo);
        }
        logger.info("Photo successfully removed. Photo details: " + photo);
    }
}
