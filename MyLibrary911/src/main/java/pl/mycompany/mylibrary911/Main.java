package pl.mycompany.mylibrary911;

import java.util.List;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.mycompany.mylibrary911.database.dao.BookDAO;
import pl.mycompany.mylibrary911.database.dbUtils.HibernateUtil;
import pl.mycompany.mylibrary911.database.models.Book;
import pl.mycompany.mylibrary911.utils.FXMLUtils;
import pl.mycompany.mylibrary911.utils.ResourceBundlesUtils;

/**
 *
 * @author Aleksander Szepelak
 */
public class Main extends Application{
    
    public static final String MAIN_SCENE = "/fxml/MainScene.fxml"; // Ścieżka do pliku FXML
        
    public static void main(String[] args) {
        launch(args);
        HibernateUtil.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLUtils.fxmlLoader(MAIN_SCENE); // Załadowanie pliku FXML
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle(ResourceBundlesUtils.getString("title.application"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
