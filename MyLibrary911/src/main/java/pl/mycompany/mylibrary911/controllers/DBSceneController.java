package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.mycompany.mylibrary911.modelFX.BookFX;
import pl.mycompany.mylibrary911.modelFX.BookModel;
import pl.mycompany.mylibrary911.utils.DialogsUtils;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 * FXML Controller class - kontroler okienka z tabelami
 *
 * @author Aleksander Szepelak
 */
public class DBSceneController implements Initializable {

    @FXML
    private TableView<BookFX> bookTableView;
    @FXML
    private TableColumn<BookFX, Integer> idBookColumn;
    @FXML
    private TableColumn<BookFX, String> titleColumn;
    @FXML
    private TableColumn<BookFX, String> authorColumn;
    @FXML
    private TableColumn<BookFX, String> publishingHouseColumn;
    @FXML
    private TableColumn<BookFX, Integer> publishmentYearColumn;
    @FXML
    private TableColumn<BookFX, Boolean> borrowedColumn;
    
    private BookModel bookModel;
    
    @FXML
    private ListView<BookFX> listView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bookModel = new BookModel();
        try {
            bookModel.initObservableList();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
        listView.setItems(this.bookModel.getBookList());
        bookTableView.setItems(this.bookModel.getBookList());
        
    }    
    
}
