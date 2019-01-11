package pl.mycompany.mylibrary911.database.dao;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.mycompany.mylibrary911.database.dbUtils.HibernateUtil;
import pl.mycompany.mylibrary911.database.models.Reader;
import pl.mycompany.mylibrary911.utils.ResourceBundlesUtils;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 *
 * @author Aleksander Szepelak
 */
public class ReaderDAO {
    
    /** Wstaw nowy rekord Book do bazy danych */
    public static void save(Reader reader) throws ApplicationException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(reader);
            transaction.commit();
            session.close();
        } catch (Throwable ex) {
            throw new ApplicationException(ResourceBundlesUtils.getResourceBundle().getString("ex.db.save.reader") + "\n" + ex.getMessage());
        }
    }
    
    /** Usuń wybrany rekord Reader z bazy danych */
    public static void delete(Reader reader) throws ApplicationException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(reader);
            transaction.commit();
            session.close();
        } catch (Throwable ex) {
            throw new ApplicationException(ResourceBundlesUtils.getResourceBundle().getString("ex.db.delete.borrow") + "\n" + ex.getMessage());
        }
    }
    
    /** Pobierz z bazy danych wszystkie encje */
    public static ArrayList<Reader> qeryForAll() throws ApplicationException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            ArrayList<Reader> list = (ArrayList<Reader>) session.createSQLQuery("SELECT * FROM reader").addEntity(Reader.class).list();
            session.close();
            return list;
        } catch (Throwable ex) {
            throw new ApplicationException(ResourceBundlesUtils.getResourceBundle().getString("ex.db.queryForAll.borrow") + "\n" + ex.getMessage());
        }
    }
}
