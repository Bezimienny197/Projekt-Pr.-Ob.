package pl.mycompany.mylibrary911.controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.mycompany.mylibrary911.modelFX.BookFX;
import pl.mycompany.mylibrary911.modelFX.BookModel;
import pl.mycompany.mylibrary911.modelFX.BorrowFX;
import pl.mycompany.mylibrary911.modelFX.BorrowModel;
import pl.mycompany.mylibrary911.modelFX.ReaderFX;
import pl.mycompany.mylibrary911.modelFX.ReaderModel;
import pl.mycompany.mylibrary911.utils.DialogsUtils;
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
    private TableColumn<BorrowFX, String> bookColumn;
    @FXML
    private TableColumn<BorrowFX, String> readerColumn;
    @FXML
    private TableColumn<BorrowFX, Date> dateOfRentalColumn;
    @FXML
    private TableColumn<BorrowFX, Date> dateOfReturnColumn;
    
    /* Modele danych */
    private BookModel bookModel;
    private ReaderModel readerModel;
    private BorrowModel borrowModel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bookModel = new BookModel();
        readerModel = new ReaderModel();
        borrowModel = new BorrowModel();
        
        /* Bindowanie tabel */
        this.bindingBookTableView();
        this.bindingReaderTableView();
        
        /* Bindowanie propertisów przycisków */
        this.deleteBookMenuItem.disableProperty().bind(this.bookTableView.getSelectionModel().selectedItemProperty().isNull());
        this.deleteReaderMenuItem.disableProperty().bind(this.readerTableView.getSelectionModel().selectedItemProperty().isNull());
        
        /* Bindowanie propertisów modeli danych z propertisami z tabel */
        this.bookModel.BookProperty().bind(this.bookTableView.getSelectionModel().selectedItemProperty());
        this.readerModel.ReaderProperty().bind(this.readerTableView.getSelectionModel().selectedItemProperty());
    }    
    
    @FXML
    public void deleteBookMenuAction() {
        try {
            this.bookModel.deleteSelectedBookFromDataBase();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
    }
    
    @FXML
    public void deleteReaderMenuAction() {
        try {
            this.readerModel.deleteSelectedReaderFromDataBase();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
    }
    
    
    public void bindingBookTableView() {
        try {
            this.bookModel.initObservableList();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
        
        /* Łączenie tabeli bookTableView z listą pobraną z modelu danych */
        this.bookTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.bookTableView.setItems(this.bookModel.getBookList());
        this.idBookColumn.setCellValueFactory(cellData-> cellData.getValue().idBookProperty());
        this.titleColumn.setCellValueFactory(cellData-> cellData.getValue().titleProperty());
        this.authorColumn.setCellValueFactory(cellData-> cellData.getValue().authorProperty());
        this.publishingHouseColumn.setCellValueFactory(cellData-> cellData.getValue().publishingHouseProperty());
        this.publishmentYearColumn.setCellValueFactory(cellData-> cellData.getValue().publishmentYearProperty());
    }
    
    public void bindingReaderTableView() {
        try {
            this.readerModel.initObservableList();
        } catch (ApplicationException ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
        
        /* Łączenie tabeli readerTableView z listą pobraną z modelu danych */
        this.readerTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.readerTableView.setItems(this.readerModel.getReaderList());
        this.idReaderColumn.setCellValueFactory(cellData-> cellData.getValue().idReaderProperty());
        this.firstNameColumn.setCellValueFactory(cellData-> cellData.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(cellData-> cellData.getValue().lastNameProperty());
        this.phoneNumberColumn.setCellValueFactory(cellData-> cellData.getValue().phoneNumberProperty());
    }
    
}
