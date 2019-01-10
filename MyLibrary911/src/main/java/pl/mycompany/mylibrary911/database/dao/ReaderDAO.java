package pl.mycompany.mylibrary911.database.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.mycompany.mylibrary911.database.dbUtils.HibernateUtil;
import pl.mycompany.mylibrary911.database.models.Reader;
import pl.mycompany.mylibrary911.utils.DialogsUtils;

/**
 *
 * @author Aleksander Szepelak
 */
public class ReaderDAO {
    
    /* Wstaw nowy rekord Book do bazy danych */
    public static void addNewReader(Reader reader) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(reader);
            transaction.commit();
            session.close();
        } catch (Throwable ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
    }
    
    /* Pobierz z bazy danych wszystkie encje */
    public static List<Reader> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Reader> list = (List<Reader>) session.createSQLQuery("SELECT * FROM reader").addEntity(Reader.class).list();
        session.close();
        return list;
    }
}
