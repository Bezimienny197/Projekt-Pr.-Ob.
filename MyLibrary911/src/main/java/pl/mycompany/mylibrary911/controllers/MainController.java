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
import pl.mycompany.mylibrary911.utils.DialogsUtils;
import pl.mycompany.mylibrary911.utils.FXMLUtils;

/**
 * FXML Controller class - Kontroler główny
 *
 * @author Aleksander Szepelak
 */
public class MainController implements Initializable {

    @FXML
    private BorderPane borderPane;
    
    /* Kontroler TopMenuButtons */
    @FXML
    private TopMenuButtonsController topMenuButtonsController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        topMenuButtonsController.setMainController(this);   // przekazuję referencję na tą klasę do TopMenuButtonsController
    }
    
    /* Ustaw okno w centralnej części BorderPane's */
    public void setCenter(String fxmlPath) {
        borderPane.setCenter(FXMLUtils.fxmlLoader(fxmlPath));
    }
    
    /* ------------ Menu ------------ */
    /* Zamknij */
    @FXML
    public void closeApplication(ActionEvent actionEvent) {
        Optional<ButtonType> result = DialogsUtils.confirmationDialog("exit.title", "exit.header");
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
        Stage stage = (Stage) borderPane.getScene().getWindow();                                            // Uzyskuję dostęp do Stage'a
        boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();   // Rzutuję action event na CheckMenuItem i uzyskuję dostęp do selectedProperty (wartości boolean)
        stage.setAlwaysOnTop(value);
    }
    
    /* O aplikacji */
    @FXML
    public void aboutApplication(ActionEvent actionEvent) {
        DialogsUtils.dialogAboutApplication();
    }
    
}
