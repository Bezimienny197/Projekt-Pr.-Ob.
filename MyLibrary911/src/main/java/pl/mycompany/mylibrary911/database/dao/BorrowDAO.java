package pl.mycompany.mylibrary911.database.dao;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.mycompany.mylibrary911.database.dbUtils.HibernateUtil;
import pl.mycompany.mylibrary911.database.models.Borrow;
import pl.mycompany.mylibrary911.utils.ResourceBundlesUtils;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 *
 * @author Aleksander Szepelak
 */
public class BorrowDAO {
    
    /** Wstaw nowy rekord Borrow do bazy danych */
    public static void save(Borrow borrow) throws ApplicationException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(borrow);
            transaction.commit();
            session.close();
        } catch (Throwable ex) {
            throw new ApplicationException(ResourceBundlesUtils.getResourceBundle().getString("ex.db.save.borrow") + "\n" + ex.getMessage());
        }
    }
    
    /** Zaktualizuj wybrany rekord Borrow w bazie danych */
    public static void update(Borrow borrow) throws ApplicationException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(borrow);
            transaction.commit();
            session.close();
        } catch (Throwable ex) {
            throw new ApplicationException(ResourceBundlesUtils.getResourceBundle().getString("ex.db.update.borrow") + "\n" + ex.getMessage());
        }
    }
    
    /** Usuń wybrany rekord Borrow z bazy danych */
    public static void delete(Borrow borrow) throws ApplicationException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(borrow);
            transaction.commit();
            session.close();
        } catch (Throwable ex) {
            throw new ApplicationException(ResourceBundlesUtils.getResourceBundle().getString("ex.db.save.borrow") + "\n" + ex.getMessage());
        }
    }
    
    /** Pobierz z bazy danych wszystkie encje */
    public static ArrayList<Borrow> qeryForAll() throws ApplicationException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            ArrayList<Borrow> list = (ArrayList<Borrow>) session.createSQLQuery("SELECT * FROM borrow").addEntity(Borrow.class).list();
            session.close();
            return list;
        } catch (Throwable ex) {
            throw new ApplicationException(ResourceBundlesUtils.getResourceBundle().getString("ex.db.queryForAll.borrow") + "\n" + ex.getMessage());
        }
    }
}
