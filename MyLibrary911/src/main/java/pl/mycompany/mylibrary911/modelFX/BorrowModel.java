package pl.mycompany.mylibrary911.modelFX;

import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.mycompany.mylibrary911.database.dao.BorrowDAO;
import pl.mycompany.mylibrary911.database.models.Book;
import pl.mycompany.mylibrary911.database.models.Borrow;
import pl.mycompany.mylibrary911.database.models.Reader;
import pl.mycompany.mylibrary911.utils.converters.BorrowConverter;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 * Model danych klasy Borrow
 *
 * @author Aleksander Szepelak
 */
public class BorrowModel {
    private ObservableList<BorrowFX> borrowList = FXCollections.observableArrayList();
    private ObjectProperty<BorrowFX> borrow = new SimpleObjectProperty();

    public ObservableList<BorrowFX> getBorrowList() {
        return borrowList;
    }
    public void setBorrowList(ObservableList<BorrowFX> borrowList) {
        this.borrowList = borrowList;
    }

    public ObjectProperty<BorrowFX> getBorrow() {
        return borrow;
    }
    public void setBorrow(ObjectProperty<BorrowFX> borrow) {
        this.borrow = borrow;
    }
    
    /** Metoda inicjalizująca ObservableList z bazy danych */
    public void initObservableList() throws ApplicationException {
        this.borrowList.clear();
        this.borrowList.addAll(BorrowConverter.toBorrowFXList(BorrowDAO.qeryForAll()));
    }
    
    /** Metoda zapisująca wypożyczenie (Borrow) w bazie danych i odświeżająca listę */
    public void saveBorrowInDataBase(Book book, Reader reader, Date dateOfRental) throws ApplicationException {
        Borrow locBorrow = new Borrow(book, reader, dateOfRental);
        BorrowDAO.save(locBorrow);
        this.initObservableList();
    }
    
    /** Metoda zapisująca wypożyczenie (Borrow) w bazie danych i odświeżająca listę */
    public void saveBorrowInDataBase(Book book, Reader reader, Date dateOfRental, Date dateOfReturn) throws ApplicationException {
        Borrow locBorrow = new Borrow(book, reader, dateOfRental, dateOfReturn);
        BorrowDAO.save(locBorrow);
        this.initObservableList();
    }
    
    /** Metoda usówająca wypożyczenie (Borrow) z bazy danych i odświeżająca listę */
    public void deleteBorrowFromDataBase(BorrowFX locBorrowFX) throws ApplicationException {
        BorrowDAO.delete(BorrowConverter.toBorrow(locBorrowFX));
        this.initObservableList();
    }
    
}
