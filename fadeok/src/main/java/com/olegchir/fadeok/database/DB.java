package com.olegchir.fadeok.database;
/**
 * Copyright (C) 2015 Oleg Chirukhin
 * Licensed under the Apache License 2.0,
 * see LICENSE-2.0.txt, LICENSE (it's a copy of LICENSE-2.0.txt) and NOTICE for additional information.
 */


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by olegchir on 27.12.14.
 */
public class DB {

    public static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("fadeok").createEntityManager();
    }

    public static void executeInTransaction(Transactable ops) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fadeok");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        ops.run(em, tx);

        em.close();
        emf.close();
    }
}
