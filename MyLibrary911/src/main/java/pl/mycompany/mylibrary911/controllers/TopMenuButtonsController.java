package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pl.mycompany.mylibrary911.modelFX.BookModel;
import pl.mycompany.mylibrary911.utils.DialogsUtils;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 * FXML Controller class - Kontroler przycisków pod menu górnym
 *
 * @author Aleksander Szepelak
 */
public class TopMenuButtonsController implements Initializable {

    /* Ścieżki do plików FXML */
    public static final String RENT_BOOK_FXML = "";
    public static final String DATA_BASE_FXML = "";
    
    /* Referencja do kontrolera głównego (potrzebna do ustawiania centralnej części BorderPane'a*/
    private MainController mainController;
    
    private BookModel bookModel = new BookModel();
    
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
        
        try {
            bookModel.initObservableList();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
     }
    
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    
    
    
}
