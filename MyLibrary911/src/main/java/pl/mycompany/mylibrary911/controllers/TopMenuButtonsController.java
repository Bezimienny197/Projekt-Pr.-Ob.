package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class - Kontroler przycisków pod menu górnym
 *
 * @author Aleksander Szepelak
 */
public class TopMenuButtonsController implements Initializable {

    /* Ścieżki do plików FXML */
    public static final String RENT_BOOK_FXML = "/fxml/RentBook.fxml";
    public static final String DATA_BASE_FXML = "/fxml/DBScene.fxml";
    public static final String ADD_BOOK_FXML = "/fxml/AddBook.fxml";
    public static final String ADD_READER_FXML = "/fxml/AddReader.fxml";
    
    /* Referencja do kontrolera głównego (potrzebna do ustawiania centralnej części BorderPane'a*/
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
        mainController.setCenter(ADD_BOOK_FXML);
     }
    
    @FXML
    public void addNewReader() {
        mainController.setCenter(ADD_READER_FXML);
     }
    
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    
    
    
}
