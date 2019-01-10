package pl.mycompany.mylibrary911.utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * Klasa służąca do obsługi plików FXML
 *
 * @author Aleksander Szepelak
 */
public class FXMLUtils {
    
    public static Pane fxmlLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(FXMLUtils.class.getResource(fxmlPath));
        loader.setResources(ResourceBundlesUtils.getResourceBundle());
        try {
            return loader.load();
        } catch (IOException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
        return null;
    }
    
}
