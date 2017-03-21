package ru.ocean.animals.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ocean.animals.model.Tag;

import java.util.List;

@Repository
public class TagDaoImpl implements TagDao {
    private static final Logger logger = LoggerFactory.getLogger(TagDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addTag(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(tag);
        logger.info("Tag successfully added. Tag details: " + tag);
    }

    public void updateTag(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tag);
        logger.info("Tag successfully updated. Tag details: " + tag);
    }

    public Tag getTagById(long id) {
        Session session = sessionFactory.getCurrentSession();

        Tag tag = (Tag) session.load(Tag.class, new Long(id));
        logger.info("Tag successfully loaded. Tag details: " + tag);
        return tag;
    }

    @Override
    public Tag getTagBySysString(String str) {
        Session session = sessionFactory.getCurrentSession();

        Long id = Long.parseLong(str);
        Tag tag = (Tag) session.load(Tag.class, id);
        logger.info("Tag successfully loaded. Tag details: " + tag);

        return tag;
    }

    @SuppressWarnings("unchecked")
    public List<Tag> getTags() {
        Session session = sessionFactory.getCurrentSession();

        List<Tag> tags = session.createQuery("from Tag").list();
        logger.info("Tag list successfully loaded. Tag details: " + tags);
        return tags;
    }

    public void removeTag(long id) {
        Session session = sessionFactory.getCurrentSession();

        Tag tag = (Tag) session.load(Tag.class, new Long(id));

        if(tag != null) {
            session.delete(tag);
        }

        logger.info("Tag successfully removed. Tag details: " + tag);
    }
}
