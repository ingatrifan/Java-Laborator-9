package org.lab9.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static PersistenceUtil persistenceUtil;
    static {
        persistenceUtil = new PersistenceUtil();
    }

    public static PersistenceUtil getPersistenceUtil() {
        return persistenceUtil;
    }

    public static EntityManagerFactory createEMFactory(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MusicAlbumPU");
        return  factory;
    }
}
