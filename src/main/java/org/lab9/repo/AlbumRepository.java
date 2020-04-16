package org.lab9.repo;


import org.lab9.entity.Album;
import org.lab9.entity.Artist;
import org.lab9.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository {
    public static void create(Album album){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static Album findById(int id){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        Album album = entityManager.find(Album.class,id);
        entityManager.close();
        return  album;
    }
    public static List<Album> findByName(String name){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        TypedQuery<Album> query = entityManager.createNamedQuery("Album.findByName",Album.class)
                .setParameter("name",name);
        List<Album> albums = query.getResultList();
        entityManager.close();
        return albums;
    }
    public static List<Album> findByArtistId(int artistId){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        TypedQuery<Album> query = entityManager.createNamedQuery("Album.findAlbumByArtistId",Album.class)
                .setParameter("artistId",artistId);
        List<Album> albums = query.getResultList();
        entityManager.close();
        return albums;
    }
}
