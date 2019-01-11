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

    public IntegerProperty getIdBook() {
        return idBook;
    }
    public void setIdBook(IntegerProperty idBook) {
        this.idBook = idBook;
    }
    public void setIdBook(Integer idBook) {
        this.idBook.set(idBook);
    }

    public StringProperty getTitle() {
        return title;
    }
    public void setTitle(StringProperty title) {
        this.title = title;
    }
      public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty getAuthor() {
        return author;
    }
    public void setAuthor(StringProperty author) {
        this.author = author;
    }
      public void setAuthor(String author) {
        this.author.set(author);
    }

    public StringProperty getPublishingHouse() {
        return publishingHouse;
    }
    public void setPublishingHouse(StringProperty publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
     public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse.set(publishingHouse);
    }

    public IntegerProperty getPublishmentYear() {
        return publishmentYear;
    }
    public void setPublishmentYear(IntegerProperty publishmentYear) {
        this.publishmentYear = publishmentYear;
    }
     public void setPublishmentYear(Integer publishmentYear) {
        this.publishmentYear.set(publishmentYear);
    }

    public BooleanProperty getBorrowed() {
        return borrowed;
    }
    public void setBorrowed(BooleanProperty borrowed) {
        this.borrowed = borrowed;
    }
    public void setBorrowed(Boolean borrowed) {
        this.borrowed.set(borrowed);
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
        return this.getBookName() + " " + this.getPublishingHouse().getValue() + " " + this.getPublishmentYear().getValue();
    }

    /** Zwraca tytół i autora książki */
    public String getBookName() {
        return "\"" + this.getTitle().getValue() + "\" " + this.getAuthor().getValue();
    }
    
}
