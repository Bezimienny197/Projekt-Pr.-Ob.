package pl.mycompany.mylibrary911;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Bezimienny197
 */
public class Main extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScene.fxml"));
        
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");   // Dodaję ResourceBundle do aplikacji
        loader.setResources(bundle);                                                                            //
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle(bundle.getString("title.application"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
