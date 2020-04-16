package org.lab9.repo;

import org.lab9.entity.Album;
import org.lab9.entity.Artist;
import org.lab9.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {
    public static void create(Artist artist){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static Artist findById(int id){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        Artist artist = entityManager.find(Artist.class,id);
        entityManager.close();
        return  artist;
    }
    public static List<Artist> findByName(String name){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        TypedQuery<Artist> query = entityManager.createNamedQuery("Artist.findByName",Artist.class)
                .setParameter("name",name);
        List<Artist> artists = query.getResultList();
        entityManager.close();
        return  artists;
    }
}
