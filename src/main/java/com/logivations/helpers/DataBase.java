package com.logivations.helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBase {
    public static <T> void createObjectInDB(T type) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(type);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
