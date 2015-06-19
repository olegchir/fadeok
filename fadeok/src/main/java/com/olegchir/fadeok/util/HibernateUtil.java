package com.olegchir.fadeok.util;

/**
 * Created by olegchir on 19.06.2015.
 */
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;


    public HibernateUtil() {
        buildSessionFactory();
    }

    private static void buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static volatile HibernateUtil instance;

    public static HibernateUtil getInstance() {
        HibernateUtil localInstance = instance;
        if (localInstance == null) {
            synchronized (HibernateUtil.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new HibernateUtil();
                }
            }
        }
        return localInstance;
    }

}