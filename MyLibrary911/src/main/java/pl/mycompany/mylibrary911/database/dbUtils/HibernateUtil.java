package pl.mycompany.mylibrary911.database.dbUtils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import pl.mycompany.mylibrary911.utils.DialogsUtils;
import pl.mycompany.mylibrary911.utils.ResourceBundlesUtils;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 * Klasa służąca do połączenia z bazą danych.
 *
 * @author Aleksander Szepelak
 */
public class HibernateUtil {

    private static final Configuration CONFIGURATION;
    private static final ServiceRegistry SERVICE_REGISTRY;
    private static final SessionFactory SESSION_FACTORY;
    
    static {
        try {
            CONFIGURATION = new Configuration().configure("/database/cfg/hibernateMySQL.cfg.xml");
            SERVICE_REGISTRY = new StandardServiceRegistryBuilder().applySettings(CONFIGURATION.getProperties()).build();
            SESSION_FACTORY = CONFIGURATION.buildSessionFactory(SERVICE_REGISTRY);
        } catch (Throwable ex) {
            // Log the exception. 
           DialogsUtils.errorDialog(ResourceBundlesUtils.getResourceBundle().getString("ex.db.connection") + "\n" + ex.getMessage());
           throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
    
    public static void close() {
        SESSION_FACTORY.close();
        StandardServiceRegistryBuilder.destroy(SERVICE_REGISTRY);
    }
}
