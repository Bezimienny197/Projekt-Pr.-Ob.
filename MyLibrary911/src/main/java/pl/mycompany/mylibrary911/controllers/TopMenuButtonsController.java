package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import pl.mycompany.mylibrary911.database.models.Book;
import pl.mycompany.mylibrary911.utils.DialogsUtils;

/**
 * FXML Controller class - Kontroler przycisków pod menu górnym
 *
 * @author Aleksander Szepelak
 */
public class TopMenuButtonsController implements Initializable {

    /* Ścieżki do plików FXML */
    public static final String RENT_BOOK_FXML = "";
    public static final String DATA_BASE_FXML = "";
    
    /* Referencja do kontrolera głównego */
    private MainController mainController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    /* Wypożycz książkę */
    @FXML
    public void openRentBook() {
        mainController.setCenter(RENT_BOOK_FXML);
    }
    
    /* Otwórz okno bazy danych */
    @FXML
    public void openDataBase() {
        mainController.setCenter(DATA_BASE_FXML);
    }
    
    @FXML
    public void addNewBook() {
        try{
        Book book = new Book("Pan Tadeusz", "Adam Mickiewicz", 2002 , false);
        Configuration configuration = new Configuration().configure("/database/cfg/hibernateMySQL.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
        factory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
        
        }  catch (Throwable ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
    }
    
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    
    
    
}
