package pl.mycompany.mylibrary911.modelFX;

import java.util.Set;
import javafx.beans.property.*;

/**
 * Model danych klasy Reader w postaci Properties'ów dla JavaFX
 * 
 * @author Alesander Szepelak
 */
public class ReaderFX {
    
    private IntegerProperty idReader = new SimpleIntegerProperty();
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private IntegerProperty phoneNumber = new SimpleIntegerProperty();
    private ObjectProperty<Set> borrows = new SimpleObjectProperty<>();

    public IntegerProperty getIdReader() {
        return idReader;
    }
    public void setIdReader(IntegerProperty idReader) {
        this.idReader = idReader;
    }
    public void setIdReader(Integer idReader) {
        this.idReader.set(idReader);
    }
    

    public StringProperty getFirstName() {
        return firstName;
    }
    public void setFirstName(StringProperty firstName) {
        this.firstName = firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty getLastName() {
        return lastName;
    }
    public void setLastName(StringProperty lastName) {
        this.lastName = lastName;
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public IntegerProperty getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(IntegerProperty phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
    
    public ObjectProperty<Set> getBorrows() {
        return borrows;
    }
    public void setBorrows(ObjectProperty<Set> borrows) {
        this.borrows = borrows;
    }
    public void setBorrows(Set borrows) {
        this.borrows.set(borrows);
    }

    @Override
    public String toString() {
        return this.getFirstName().getValue() + " " + this.getLastName().getValue();
    }
    
}
