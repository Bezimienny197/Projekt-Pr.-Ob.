package pl.mycompany.mylibrary911.database.dao;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.mycompany.mylibrary911.database.models.Book;
import pl.mycompany.mylibrary911.database.dbUtils.HibernateUtil;
import pl.mycompany.mylibrary911.utils.ResourceBundlesUtils;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 * Klasa odpowiadająca za komunikację z tabelą book w bazie danych
 *
 * @author Alesander Szepelak
 */
public class BookDAO {
    
    /** Wstaw nowy rekord Book do bazy danych */
    public static void save(Book book) throws ApplicationException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            session.close();
        } catch (Throwable ex) {
            throw new ApplicationException(ResourceBundlesUtils.getResourceBundle().getString("ex.db.delete.book") + "\n" + ex.getMessage());
        }
    }
    
    /** Usuń podany rekord Book z bazy danych */
    public static void delete(Book book) throws ApplicationException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
            session.close();
        } catch (Throwable ex) {
            throw new ApplicationException(ResourceBundlesUtils.getResourceBundle().getString("ex.db.delete.book") + "\n" + ex.getMessage());
        }
    }
    
    /** Pobierz z bazy danych wszystkie encje */
    public static ArrayList<Book> qeryForAll() throws ApplicationException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            ArrayList<Book> list = (ArrayList<Book>) session.createSQLQuery("SELECT * FROM book").addEntity(Book.class).list();
            session.close();
            return list;
        } catch (Throwable ex) {
            throw new ApplicationException(ResourceBundlesUtils.getResourceBundle().getString("ex.db.queryForAll.book") + "\n" + ex.getMessage());
        }
    }
}
