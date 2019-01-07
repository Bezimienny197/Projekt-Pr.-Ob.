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
public class TopMenuButtonsController implements Initializable {

    /* Referencja do MainController'a */
    private MainController mainController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void openRentBook() {
        
    }
    
    @FXML
    public void openDataBase() {
        
    }
    
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    
    
    
}
