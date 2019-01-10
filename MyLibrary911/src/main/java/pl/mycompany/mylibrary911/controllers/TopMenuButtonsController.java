package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pl.mycompany.mylibrary911.database.dao.BookDAO;
import pl.mycompany.mylibrary911.database.models.Book;

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
        /* Book book = new Book("Pan Tadeusz", "Adam Mickiewicz", 2002 , false);
        BookDAO.addNewBook(book); */
     }
    
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    
    
    
}
