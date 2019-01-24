package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.mycompany.mylibrary911.database.models.Book;
import pl.mycompany.mylibrary911.database.models.Reader;
import pl.mycompany.mylibrary911.modelFX.*;
import pl.mycompany.mylibrary911.utils.DialogsUtils;
import pl.mycompany.mylibrary911.utils.ResourceBundlesUtils;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 * FXML Controller class - kontroler okna z tabelami
 *
 * @author Aleksander Szepelak
 */
public class DBSceneController implements Initializable {

    /* Tabela książek */
    @FXML
    private TableView<BookFX> bookTableView;
    @FXML
    private TableColumn<BookFX, Number> idBookColumn;
    @FXML
    private TableColumn<BookFX, String> titleColumn;
    @FXML
    private TableColumn<BookFX, String> authorColumn;
    @FXML
    private TableColumn<BookFX, String> publishingHouseColumn;
    @FXML
    private TableColumn<BookFX, Number> publishmentYearColumn;
    @FXML
    private TableColumn<BookFX, Boolean> borrowedColumn;
    @FXML
    private MenuItem deleteBookMenuItem;
    
    /* Tabela czytelników */
    @FXML
    private TableView<ReaderFX> readerTableView;
    @FXML
    private TableColumn<ReaderFX, Number> idReaderColumn;
    @FXML
    private TableColumn<ReaderFX, String> firstNameColumn;
    @FXML
    private TableColumn<ReaderFX, String> lastNameColumn;
    @FXML
    private TableColumn<ReaderFX, Integer> phoneNumberColumn;
    @FXML
    private MenuItem deleteReaderMenuItem;
    
    /* Tabela wypożyczeń */
    @FXML
    private TableView<BorrowFX> borrowsTableView;
    @FXML
    private TableColumn<BorrowFX, Book> bookColumn;
    @FXML
    private TableColumn<BorrowFX, Reader> readerColumn;
    @FXML
    private TableColumn<BorrowFX, Date> dateOfRentalColumn;
    @FXML
    private TableColumn<BorrowFX, Date> dateOfReturnColumn;
    @FXML
    private MenuItem returnBookMenuItem;
    
    /* Modele danych */
    private BookModel bookModel;
    private ReaderModel readerModel;
    private BorrowModel borrowModel;
    
    /* Zmienna służąca do pobierania String'ów z oddzielnego pliku */
    ResourceBundle bundle = ResourceBundlesUtils.getResourceBundle();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bookModel = new BookModel();
        readerModel = new ReaderModel();
        borrowModel = new BorrowModel();
        
        this.initData();
        
        /* Bindowanie tabel */
        this.bindingBookTableView();
        this.bindingReaderTableView();
        this.bindingBorrowTableView();
        
        /* Pozostałe bindowania */
        this.bindings();
    }    
    
    
    /* Edycja danych */
    @FXML
    public void titleEdit(TableColumn.CellEditEvent<BookFX, String> e) {
        
    }
    @FXML
    public void authorEdit(TableColumn.CellEditEvent<BookFX, String> e) {
        
    }
    @FXML
    public void publishingHouseEdit(TableColumn.CellEditEvent<BookFX, String> e) {
        
    }
    @FXML
    public void publishmentYearEdit(TableColumn.CellEditEvent<BookFX, Number> e) {
        
    }
    
    @FXML
    public void deleteBookMenuAction() {
        Optional<ButtonType> result = DialogsUtils.confirmationDialog("deleteBook.title", "deleteBook.header");
        if (result.get() == ButtonType.OK) {
            try {
                this.bookModel.deleteSelectedBookFromDataBase();
            } catch (ApplicationException ex) {
                DialogsUtils.errorDialog(ex.getMessage());
            }
        }
    }
    
    @FXML
    public void firstNameEdit(TableColumn.CellEditEvent<ReaderFX, String> e) {
        
    }
    @FXML
    public void lastNameEdit(TableColumn.CellEditEvent<ReaderFX, String> e) {
        
    }
    @FXML
    public void phoneNumberEdit(TableColumn.CellEditEvent<ReaderFX, Integer> e) {
        
    }
    
    @FXML
    public void deleteReaderMenuAction() {
        Optional<ButtonType> result = DialogsUtils.confirmationDialog("deleteReader.title", "deleteReader.header");
        if (result.get() == ButtonType.OK) {
            try {
                this.readerModel.deleteSelectedReaderFromDataBase();
            } catch (ApplicationException ex) {
                DialogsUtils.errorDialog(ex.getMessage());
            }
        }
    }
    
    /* Zwracanie książki do biblioteki */
    @FXML
    public void returnBookAction() {
        try {
            Book book = this.borrowModel.BorrowProperty().getValue().bookProperty().getValue();
            book.setBorrowed(false);
            this.bookModel.updateBookInDataBase(book);
            this.borrowModel.BorrowProperty().getValue().setDateOfReturn(new Date());
            this.borrowModel.updateSelectedBorrowInDataBase();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
        
    }
    
    /* Inicjalizacja list z bazy danych */
    private void initData() {
        try {
            this.bookModel.initObservableList();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
        
        try {
            this.readerModel.initObservableList();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
        
        try {
            this.borrowModel.initObservableList();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
    }
    
    private void bindingBookTableView() {
        /* Łączenie tabeli bookTableView z listą pobraną z modelu danych */
        this.bookTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);  // Tabelka dopasowóje się do dostępnego miejsca
        this.bookTableView.setItems(this.bookModel.getBookList());
        this.idBookColumn.setCellValueFactory(cellData-> cellData.getValue().idBookProperty());
        this.titleColumn.setCellValueFactory(cellData-> cellData.getValue().titleProperty());
        this.authorColumn.setCellValueFactory(cellData-> cellData.getValue().authorProperty());
        this.publishingHouseColumn.setCellValueFactory(cellData-> cellData.getValue().publishingHouseProperty());
        this.publishmentYearColumn.setCellValueFactory(cellData-> cellData.getValue().publishmentYearProperty());
        this.borrowedColumn.setCellValueFactory(cellData-> cellData.getValue().borrowedProperty());
        
        /* Funkcja wyświetlająca "Tak" lub "Nie" zamiast "true" lub "false" */
        this.borrowedColumn.setCellFactory(column -> new TableCell<BookFX, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item ? bundle.getString("booksTab.borrowed.yes") : bundle.getString("booksTab.borrowed.no"));
            }
        });
    }
    
    private void bindingReaderTableView() {
        /* Łączenie tabeli readerTableView z listą pobraną z modelu danych */
        this.readerTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);    // Tabelka dopasowóje się do dostępnego miejsca
        this.readerTableView.setItems(this.readerModel.getReaderList());
        this.idReaderColumn.setCellValueFactory(cellData-> cellData.getValue().idReaderProperty());
        this.firstNameColumn.setCellValueFactory(cellData-> cellData.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(cellData-> cellData.getValue().lastNameProperty());
        this.phoneNumberColumn.setCellValueFactory(cellData-> cellData.getValue().phoneNumberProperty());
    }
    
    private void bindingBorrowTableView() {
        /* Łączenie tabeli borrowTableView z listą pobraną z modelu danych */
        this.borrowsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);    // Tabelka dopasowóje się do dostępnego miejsca
        this.borrowsTableView.setItems(this.borrowModel.getBorrowList());
        this.bookColumn.setCellValueFactory(cellData-> cellData.getValue().bookProperty());
        this.readerColumn.setCellValueFactory(cellData-> cellData.getValue().readerProperty());
        this.dateOfRentalColumn.setCellValueFactory(cellData-> cellData.getValue().dateOfRentalProperty());
        this.dateOfReturnColumn.setCellValueFactory(cellData-> cellData.getValue().dateOfReturnProperty());
        
    }
    
    private void bindings() {
       
        /* Bindowanie propertisów przycisków */
        // this.editBookMenuItem.disableProperty().bind(this.bookTableView.getSelectionModel().selectedItemProperty().isNull());       // Wyłącz przyciski jeśli
        this.deleteBookMenuItem.disableProperty().bind(this.bookTableView.getSelectionModel().selectedItemProperty().isNull());       // nic nie jest zaznaczone
        // this.editReaderMenuItem.disableProperty().bind(this.readerTableView.getSelectionModel().selectedItemProperty().isNull());// lub
        this.deleteReaderMenuItem.disableProperty().bind(this.readerTableView.getSelectionModel().selectedItemProperty().isNull()); // tabela jest pusta.
        this.returnBookMenuItem.disableProperty().bind(this.borrowsTableView.getSelectionModel().selectedItemProperty().isNull());  //
        
        /* Bindowanie propertisów modeli danych z propertisami z tabel */
        this.bookModel.BookProperty().bind(this.bookTableView.getSelectionModel().selectedItemProperty());
        this.readerModel.ReaderProperty().bind(this.readerTableView.getSelectionModel().selectedItemProperty());
        this.borrowModel.BorrowProperty().bind(this.borrowsTableView.getSelectionModel().selectedItemProperty());
    }
    
}
