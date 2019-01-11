package pl.mycompany.mylibrary911.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.mycompany.mylibrary911.database.dao.ReaderDAO;
import pl.mycompany.mylibrary911.database.models.Reader;
import pl.mycompany.mylibrary911.utils.converters.ReaderConverter;
import pl.mycompany.mylibrary911.utils.exceptions.ApplicationException;

/**
 * 
 * Model danych klasy Reader
 *
 * @author Aleksander Szepelak
 */
public class ReaderModel {
    private ObservableList<ReaderFX> readerList = FXCollections.observableArrayList();
    private ObjectProperty<ReaderFX> reader = new SimpleObjectProperty();

    public ObservableList<ReaderFX> getBookList() {
        return readerList;
    }
    public void setReaderList(ObservableList<ReaderFX> readerList) {
        this.readerList = readerList;
    }

    public ObjectProperty<ReaderFX> getReader() {
        return reader;
    }
    public void setReader(ObjectProperty<ReaderFX> reader) {
        this.reader = reader;
    }
    
    /** Metoda inicjalizująca ObservableList z bazy danych */
    public void initObservableList() throws ApplicationException {
        this.readerList.clear();
        this.readerList.addAll(ReaderConverter.toReaderFXList(ReaderDAO.qeryForAll()));
    }
    
    /** Metoda zapisująca czytelnika (Reader) w bazie danych i odświeżająca listę */
    public void saveReaderInDataBase(String firstName, String lastName) throws ApplicationException {
        Reader locReader = new Reader(firstName, lastName);
        ReaderDAO.save(locReader);
        this.initObservableList();
    }
    
    /** Metoda zapisująca czytelnika (Reader) w bazie danych i odświeżająca listę */
    public void saveReaderInDataBase(String firstName, String lastName, Integer phoneNumber) throws ApplicationException {
        Reader locReader = new Reader(firstName, lastName, phoneNumber);
        ReaderDAO.save(locReader);
        this.initObservableList();
    }
    
    /** Metoda usówająca czytelnika (Reader) z bazy danych i odświeżająca listę */
    public void deleteReaderFromDataBase(ReaderFX locReaderFX) throws ApplicationException {
        ReaderDAO.delete(ReaderConverter.toReader(locReaderFX));
        this.initObservableList();
    }
    
}
