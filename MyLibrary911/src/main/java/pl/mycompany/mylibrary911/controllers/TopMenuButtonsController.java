package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Bezimienny197
 */
/* Kontroler przycisków pod menu górnym */
public class TopMenuButtonsController implements Initializable {

    /* Referencja do kontrolera głównego */
    private MainController mainController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    /* Wypożycz książkę */
    @FXML
    public void openRentBook() {
        
    }
    
    /* Otwórz okno bazy danych */
    @FXML
    public void openDataBase() {
        
    }
    
    /* Ustaw okno w centralnej części BorderPane's */
    public void setCenter(String fxmlPath) {
        
    }
    
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    
    
    
}
