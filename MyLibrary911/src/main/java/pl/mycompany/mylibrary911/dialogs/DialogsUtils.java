package pl.mycompany.mylibrary911.dialogs;

import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Bezimienny197
 */
/* Klasa służąca do obsługi okien dialogowych */
public class DialogsUtils {
   static  ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
    
   /* Okno dialogowe O aplikacji */
    public static void dialogAboutApplication() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("about.title"));
        informationAlert.setHeaderText(bundle.getString("about.header"));
        informationAlert.setContentText(bundle.getString("about.content"));
        informationAlert.showAndWait();
    }
    
    /* Okno dialogowe Zamknij */
    public static Optional<ButtonType> dialogConfirmation() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle(bundle.getString("exit.title"));
        confirmationAlert.setHeaderText(bundle.getString("exit.header"));
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        return result;
    }
    
}
