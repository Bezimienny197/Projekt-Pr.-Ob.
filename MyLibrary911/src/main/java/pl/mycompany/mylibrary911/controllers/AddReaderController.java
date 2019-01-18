package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.mycompany.mylibrary911.modelFX.ReaderModel;
import pl.mycompany.mylibrary911.utils.DialogsUtils;
import pl.mycompany.mylibrary911.utils.ResourceBundlesUtils;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 * FXML Controller class - kontroler okna dodawania nowego czytelnika.
 *
 * @author Alesander Szepelak
 */
public class AddReaderController implements Initializable {

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private Button addReaderButton;
    
    private final ResourceBundle bundle = ResourceBundlesUtils.getResourceBundle();
    private ReaderModel readerModel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readerModel = new ReaderModel();
        addReaderButton.disableProperty().bind(this.firstNameTextField.textProperty().isEmpty().or(
                                                                       this.lastNameTextField.textProperty().isEmpty()));
    }    
    
    @FXML
    public void addReaderAction(){
        try {
            String firsName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            Integer phoneNumber;
            if (phoneNumberTextField.getText().equals("")) {
                readerModel.saveReaderInDataBase(firsName, lastName);
            } else {
                phoneNumber = Integer.parseInt(phoneNumberTextField.getText());
                readerModel.saveReaderInDataBase(firsName, lastName, phoneNumber);
            }
            
        } catch (NumberFormatException ex) {
            DialogsUtils.shortErrorDialog(bundle.getString("error.formatPhoneNumber"));
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
    }
    
}
