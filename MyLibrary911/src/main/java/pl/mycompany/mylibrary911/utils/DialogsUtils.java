package pl.mycompany.mylibrary911.utils;

import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

/**
 *  Klasa służąca do obsługi okien dialogowych
 *
 * @author Aleksander Szepelak
 */
public class DialogsUtils {
   static  ResourceBundle bundle = ResourceBundlesUtils.getResourceBundle();
    
   /** Okno dialogowe O aplikacji */
    public static void dialogAboutApplication() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("about.title"));
        informationAlert.setHeaderText(bundle.getString("about.header"));
        informationAlert.setContentText(bundle.getString("about.content"));
        
        informationAlert.showAndWait();
    }
    
    /** Okno dialogowe Zamknij */
    public static Optional<ButtonType> confirmationDialog() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle(bundle.getString("exit.title"));
        confirmationAlert.setHeaderText(bundle.getString("exit.header"));
        
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        return result;
    }
    
    /** Okno dialogowe błędów */
    public static void errorDialog(String error) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(bundle.getString("error.title"));
        errorAlert.setHeaderText(bundle.getString("error.header"));
        
        TextArea textArea = new TextArea(error);
        errorAlert.getDialogPane().setContent(textArea);
        
        errorAlert.showAndWait();
    }
    
    public static void shortErrorDialog(String error) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(bundle.getString("error.title"));
        errorAlert.setHeaderText(error);
        
        errorAlert.showAndWait();
    }
}
