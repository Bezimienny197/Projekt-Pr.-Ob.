package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Bezimienny197
 */
public class MainController implements Initializable {

    @FXML
    private BorderPane borderPane;
    
    /* Kontroler TopMenuButtons */
    @FXML
    private TopMenuButtonsController topMenuButtonsController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        topMenuButtonsController.setMainController(this);   // przekazuję referencję do TopMenuButtonsController
    }    
    
}
