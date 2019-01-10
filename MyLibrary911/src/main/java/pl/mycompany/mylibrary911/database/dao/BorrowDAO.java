package pl.mycompany.mylibrary911.database.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.mycompany.mylibrary911.database.dbUtils.HibernateUtil;
import pl.mycompany.mylibrary911.database.models.Borrow;
import pl.mycompany.mylibrary911.utils.DialogsUtils;

/**
 *
 * @author Aleksander Szepelak
 */
public class BorrowDAO {
    
    /* Wstaw nowy rekord Borrow do bazy danych */
    public static void addNewBorrow(Borrow borrow) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(borrow);
            transaction.commit();
            session.close();
        } catch (Throwable ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
    }
    
    /* Pobierz z bazy danych wszystkie encje */
    public static List<Borrow> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Borrow> list = (List<Borrow>) session.createSQLQuery("SELECT * FROM borrow").addEntity(Borrow.class).list();
        session.close();
        return list;
    }
}
