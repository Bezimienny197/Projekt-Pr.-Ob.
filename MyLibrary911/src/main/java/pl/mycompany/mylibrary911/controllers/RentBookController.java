package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pl.mycompany.mylibrary911.database.models.Book;
import pl.mycompany.mylibrary911.database.models.Reader;
import pl.mycompany.mylibrary911.modelFX.BookModel;
import pl.mycompany.mylibrary911.modelFX.BorrowModel;
import pl.mycompany.mylibrary911.modelFX.ReaderModel;
import pl.mycompany.mylibrary911.utils.DialogsUtils;
import pl.mycompany.mylibrary911.utils.converters.BookConverter;
import pl.mycompany.mylibrary911.utils.converters.ReaderConverter;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 * FXML Controller class - kontroler wypożyczeń
 *
 * @author Aleksander Szepelak
 */
public class RentBookController implements Initializable {

    @FXML
    private ListView bookListView;
    @FXML
    private ListView readerListView;
    @FXML
    private Button rentButton;
    
    private BookModel bookModel;
    private ReaderModel readerModel;
    private BorrowModel borrowModel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.bookModel = new BookModel();
        this.readerModel = new ReaderModel();
        this.borrowModel = new BorrowModel();
         
        try {
            this.bookModel.initNotBorrowedList();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        } 
        
        try {
            this.readerModel.initObservableList();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
        
        this.bookListView.setItems(this.bookModel.getBookList());
        this.readerListView.setItems(this.readerModel.getReaderList());
        this.rentButton.disableProperty().bind(this.bookListView.getSelectionModel().selectedItemProperty().isNull().or(
                                                                    this.readerListView.getSelectionModel().selectedItemProperty().isNull()));
        
        this.bookModel.BookProperty().bind(this.bookListView.getSelectionModel().selectedItemProperty());
        this.readerModel.ReaderProperty().bind(this.readerListView.getSelectionModel().selectedItemProperty());
    }    
    
    @FXML
    public void rentButtonAction() {
        try {
            this.bookModel.BookProperty().getValue().setBorrowed(true);

            Book book = BookConverter.toBook(this.bookModel.BookProperty().getValue());
            Reader reader = ReaderConverter.toReader(this.readerModel.ReaderProperty().getValue());

            this.bookModel.updateSelectedBookInDataBase();
            
            this.borrowModel.saveBorrowInDataBase(book, reader, new Date());
            
            this.bookModel.initNotBorrowedList();

        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
    }
    
}
