package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.mycompany.mylibrary911.dialogs.DialogsUtils;

/**
 * FXML Controller class
 *
 * @author Bezimienny197
 */
/* Kontroler główny */
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
    
    /* Zamknij */
    @FXML
    public void closeApplication(ActionEvent actionEvent) {
        Optional<ButtonType> result = DialogsUtils.dialogConfirmation();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
        System.exit(0);
        }
    }
    
    /* Ustaw styl Caspian */
    @FXML
    public void setCaspian(ActionEvent actionEvent) {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }
    
    /* Ustaw styl Modena */
    @FXML
    public void setModena(ActionEvent actionEvent) {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }
    
    /* Zawsze na wierzchu */
    @FXML
    public void setAlwaysOnTop(ActionEvent actionEvent) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
        stage.setAlwaysOnTop(value);
    }
    
    /* O aplikacji */
    @FXML
    public void aboutApplication(ActionEvent actionEvent) {
        DialogsUtils.dialogAboutApplication();
    }
    
}
