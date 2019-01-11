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
    private ObjectProperty<BookFX> book = new SimpleObjectProperty();

    public ObservableList<BookFX> getBookList() {
        return bookList;
    }
    public void setBookList(ObservableList<BookFX> bookList) {
        this.bookList = bookList;
    }

    public ObjectProperty<BookFX> getBook() {
        return book;
    }
    public void setBook(ObjectProperty<BookFX> book) {
        this.book = book;
    }
    
    /** Metoda inicjalizująca ObservableList z bazy danych */
    public void initObservableList() throws ApplicationException {
        this.bookList.clear();
        this.bookList.addAll(BookConverter.toBookFXList(BookDAO.qeryForAll()));
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
    
    /** Metoda usówająca książkę (Book) z bazy danych i odświeżająca listę */
    public void deleteBookFromDataBase(BookFX locBookFX) throws ApplicationException {
        BookDAO.delete(BookConverter.toBook(locBookFX));
        this.initObservableList();
    }
    
}
