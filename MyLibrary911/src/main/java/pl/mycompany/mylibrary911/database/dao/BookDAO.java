package pl.mycompany.mylibrary911.database.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.mycompany.mylibrary911.database.models.Book;
import pl.mycompany.mylibrary911.database.dbUtils.HibernateUtil;
import pl.mycompany.mylibrary911.utils.DialogsUtils;

/**
 *
 * @author Alesander Szepelak
 */
public class BookDAO {
    
    /* Wstaw nowy rekord Book do bazy danych */
    public static void addNewBook(Book book) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            session.close();
        } catch (Throwable ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
    }
    
    /* Pobierz z bazy danych wszystkie encje */
    public static List<Book> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> list = (List<Book>) session.createSQLQuery("SELECT * FROM book").addEntity(Book.class).list();
        session.close();
        return list;
    }
}
