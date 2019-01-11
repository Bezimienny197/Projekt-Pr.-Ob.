package pl.mycompany.mylibrary911.modelFX;

import java.util.Date;
import javafx.beans.property.*;
import pl.mycompany.mylibrary911.database.models.Book;
import pl.mycompany.mylibrary911.database.models.Reader;

/**
 * Model danych klasy Borrow w postaci Properties'ów dla JavaFX
 *
 * @author Aleksander Szepelak
 */
public class BorrowFX {
    
    private IntegerProperty idBorrow = new SimpleIntegerProperty();
    private ObjectProperty<Book> book = new SimpleObjectProperty<>();
    private ObjectProperty<Reader> reader = new SimpleObjectProperty<>();
    private ObjectProperty<Date> dateOfRental = new SimpleObjectProperty<>();
    private ObjectProperty<Date> dateOfReturn = new SimpleObjectProperty<>();

    public IntegerProperty getIdBorrow() {
        return idBorrow;
    }
    public void setIdBorrow(IntegerProperty idBorrow) {
        this.idBorrow = idBorrow;
    }
    public void setIdBorrow(Integer idBorrow) {
        this.idBorrow.set(idBorrow);
    }

    public ObjectProperty<Book> getBook() {
        return book;
    }
    public void setBook(ObjectProperty<Book> book) {
        this.book = book;
    }
     public void setBook(Book book) {
        this.book.set(book);
    }

    public ObjectProperty<Reader> getReader() {
        return reader;
    }
    public void setReader(ObjectProperty<Reader> reader) {
        this.reader = reader;
    }
    public void setReader(Reader reader) {
        this.reader.set(reader);
    }

    public ObjectProperty<Date> getDateOfRental() {
        return dateOfRental;
    }
    public void setDateOfRental(ObjectProperty<Date> dateOfRental) {
        this.dateOfRental = dateOfRental;
    }
    public void setDateOfRental(Date dateOfRental) {
        this.dateOfRental.set(dateOfRental);
    }

    public ObjectProperty<Date> getDateOfReturn() {
        return dateOfReturn;
    }
    public void setDateOfReturn(ObjectProperty<Date> dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn.set(dateOfReturn);
    }
    
    @Override
    public String toString() {
        if (dateOfReturn.equals(null)) {
            return this.getBook().getValue().getBookName() + " wypożyczona przzez " + this.getReader().getValue().toString() + "dnia: " + this.getDateOfRental().getValue().toString();
        } else {
            return this.getBook().getValue().getBookName() + " wypożyczona przzez " + this.getReader().getValue().toString() + "dnia: " + this.getDateOfRental().getValue().toString() + ", zwrócona dnia " + this.getDateOfReturn().getValue().toString();
        }
    }
}
