package pl.mycompany.mylibrary911.modelFX;

import java.util.Set;
import javafx.beans.property.*;

/**
 * Model danych klasy Book w postaci Properties'ów dla JavaFX
 *
 * @author Alesander Szepelak
 */
public class BookFX {
    
    private IntegerProperty idBook = new SimpleIntegerProperty();
    private StringProperty title = new SimpleStringProperty();
    private StringProperty author = new SimpleStringProperty();
    private StringProperty publishingHouse = new SimpleStringProperty();
    private IntegerProperty publishmentYear= new SimpleIntegerProperty();
    private BooleanProperty borrowed = new SimpleBooleanProperty();
    private ObjectProperty<Set> borrows = new SimpleObjectProperty<>();

    public IntegerProperty idBookProperty() {
        return idBook;
    }
    public void setIdBook(IntegerProperty idBook) {
        this.idBook = idBook;
    }
    public void setIdBook(Integer idBook) {
        this.idBook.set(idBook);
    }

    public StringProperty titleProperty() {
        return title;
    }
    public void setTitle(StringProperty title) {
        this.title = title;
    }
      public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty authorProperty() {
        return author;
    }
    public void setAuthor(StringProperty author) {
        this.author = author;
    }
      public void setAuthor(String author) {
        this.author.set(author);
    }

    public StringProperty publishingHouseProperty() {
        return publishingHouse;
    }
    public void setPublishingHouse(StringProperty publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
     public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse.set(publishingHouse);
    }

    public IntegerProperty publishmentYearProperty() {
        return publishmentYear;
    }
    public void setPublishmentYear(IntegerProperty publishmentYear) {
        this.publishmentYear = publishmentYear;
    }
     public void setPublishmentYear(Integer publishmentYear) {
        this.publishmentYear.set(publishmentYear);
    }

    public BooleanProperty borrowedProperty() {
        return borrowed;
    }
    public void setBorrowed(BooleanProperty borrowed) {
        this.borrowed = borrowed;
    }
    public void setBorrowed(Boolean borrowed) {
        this.borrowed.set(borrowed);
    }

    public ObjectProperty<Set> borrowsProperty() {
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
        if (this.publishingHouseProperty().isNull().getValue()) {
            return Integer.toString(this.idBookProperty().getValue()) + " " + this.getBookName() + " " + this.publishmentYearProperty().getValue();
        }
        return Integer.toString(this.idBookProperty().getValue()) + " " + this.getBookName() + " " + this.publishingHouseProperty().getValue() + " " + this.publishmentYearProperty().getValue();
    }

    /** Zwraca tytół i autora książki */
    public String getBookName() {
        return "\"" + this.titleProperty().getValue() + "\" " + this.authorProperty().getValue();
    }
    
}
