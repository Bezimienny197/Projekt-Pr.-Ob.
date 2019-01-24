package pl.mycompany.mylibrary911.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.mycompany.mylibrary911.database.dao.BookDAO;
import pl.mycompany.mylibrary911.database.models.Book;
import pl.mycompany.mylibrary911.utils.converters.BookConverter;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 * Model danych klasy Book
 *
 * @author Aleksander Szepelak
 */
public class BookModel {
    private ObservableList<BookFX> bookList = FXCollections.observableArrayList();
    private ObjectProperty<BookFX> bookProperty = new SimpleObjectProperty();

    public ObservableList<BookFX> getBookList() {
        return bookList;
    }
    public void setBookList(ObservableList<BookFX> bookList) {
        this.bookList = bookList;
    }

    public ObjectProperty<BookFX> BookProperty() {
        return bookProperty;
    }
    public void setBookProperty(ObjectProperty<BookFX> book) {
        this.bookProperty = book;
    }

    /** Metoda inicjalizująca ObservableList z bazy danych */
    public void initObservableList() throws ApplicationException {
        this.bookList.clear();
        this.bookList.addAll(BookConverter.toBookFXList(BookDAO.qeryForAll()));
    }
    
    /** Metoda inicjalizująca ObservableList z bazy danych (pobiera tylko niewypożyczone książki) */
    public void initNotBorrowedList() throws ApplicationException {
        this.bookList.clear();
        this.bookList.addAll(BookConverter.toBookFXList(BookDAO.qeryForNotBorrowed()));
    }
    
    /** Metoda zapisująca książkę (Book) w bazie danych i odświeżająca listę */
    public void saveBookInDataBase(String title, String author, int publishmentYear, boolean borrowed) throws ApplicationException {
        Book locBook = new Book(title, author, publishmentYear, borrowed);
        BookDAO.save(locBook);
        this.initObservableList();
    }
    
    /** Metoda zapisująca książkę (Book) w bazie danych i odświeżająca listę */
    public void saveBookInDataBase(String title, String author, String publishingHouse, int publishmentYear, boolean borrowed) throws ApplicationException {
        Book locBook = new Book(title, author, publishingHouse, publishmentYear, borrowed);
        BookDAO.save(locBook);
        this.initObservableList();
    }
    
    /** Metoda aktualizująca książką (Book) w bazie danych i odświeżająca listę */
    public void updateBookInDataBase(Book locBook) throws ApplicationException {
        BookDAO.update(locBook);
        this.initObservableList();
    }
    
    /** Metoda aktualizująca książką (Book) w bazie danych i odświeżająca listę */
    public void updateBookInDataBase(BookFX locBookFX) throws ApplicationException {
        BookDAO.update(BookConverter.toBook(locBookFX));
        this.initObservableList();
    }
    
    /** Metoda aktualizująca wybraną książką (Book) w bazie danych i odświeżająca listę */
    public void updateSelectedBookInDataBase() throws ApplicationException {
        BookDAO.update(BookConverter.toBook(this.bookProperty.getValue()));
        this.initObservableList();
    }
    
    /** Metoda usówająca książkę (Book) z bazy danych i odświeżająca listę */
    public void deleteBookFromDataBase(BookFX locBookFX) throws ApplicationException {
        BookDAO.delete(BookConverter.toBook(locBookFX));
        this.initObservableList();
    }
    
    /** Metoda usówająca wybraną książkę (Book) z bazy danych i odświeżająca listę */
    public void deleteSelectedBookFromDataBase() throws ApplicationException {
        BookDAO.delete(BookConverter.toBook(this.bookProperty.getValue()));
        this.initObservableList();
    }
    
}
