package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.mycompany.mylibrary911.modelFX.BookModel;
import pl.mycompany.mylibrary911.utils.DialogsUtils;
import pl.mycompany.mylibrary911.utils.ResourceBundlesUtils;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 * FXML Controller class - kontroler okna dodawania nowej książki
 *
 * @author Aleksander Szepelak
 */
public class AddBookController implements Initializable {

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField authorTextField;
    @FXML
    private TextField publishmentHouseTextField;
    @FXML
    private TextField publishmentYearTextField;
    @FXML
    private Button addBookButton;
    
    private final ResourceBundle bundle = ResourceBundlesUtils.getResourceBundle();
    private BookModel bookModel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bookModel = new BookModel();
        addBookButton.disableProperty().bind(this.titleTextField.textProperty().isEmpty().or(
                                                                    this.authorTextField.textProperty().isEmpty()).or(
                                                                    this.publishmentYearTextField.textProperty().isEmpty()));
    }    
    
    @FXML
    public void addBookAction(){
        try {
            String title = titleTextField.getText();
            String author = authorTextField.getText();
            String publishingHouse = publishmentHouseTextField.getText();
            Integer publishmentYear = Integer.parseInt(publishmentYearTextField.getText());
            
             bookModel.saveBookInDataBase(title, author, publishingHouse, publishmentYear, false);
        
        } catch (NumberFormatException ex) {
            DialogsUtils.shortErrorDialog(bundle.getString("error.formatPublishmentYear"));
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
    }
    
}
