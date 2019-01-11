package pl.mycompany.mylibrary911.database.models;
// Generated 2019-01-10 13:46:39 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Bazodanowy model danych klasy Book
 * 
 * Book generated by hbm2java modified by Aleksander Szepelak
 */
public class Book  implements java.io.Serializable {

    private Integer idBook;
    private String title;
    private String author;
    private String publishingHouse;
    private int publishmentYear;
    private boolean borrowed;
    private Set borrows = new HashSet(0);

    public Book() {
    }

	
    public Book(String title, String author, int publishmentYear, boolean borrowed) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublishmentYear(publishmentYear);
        this.setBorrowed(borrowed);
    }
      public Book(String title, String author, String publishingHouse, int publishmentYear, boolean borrowed) {
       this.setTitle(title);
       this.setAuthor(author);
       this.setPublishingHouse(publishingHouse);
       this.setPublishmentYear(publishmentYear);
       this.setBorrowed(borrowed);
    }
    public Book(String title, String author, String publishingHouse, int publishmentYear, boolean borrowed, Set borrows) {
       this.setTitle(title);
       this.setAuthor(author);
       this.setPublishingHouse(publishingHouse);
       this.setPublishmentYear(publishmentYear);
       this.setBorrowed(borrowed);
       this.setBorrows(borrows);
    }
   
    public Integer getIdBook() {
        return this.idBook;
    }
    
    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublishingHouse() {
        return this.publishingHouse;
    }
    
    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
    public int getPublishmentYear() {
        return this.publishmentYear;
    }
    
    public void setPublishmentYear(int publishmentYear) {
        this.publishmentYear = publishmentYear;
    }
    public boolean isBorrowed() {
        return this.borrowed;
    }
    
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
    public Set getBorrows() {
        return this.borrows;
    }
    
    public void setBorrows(Set borrows) {
        this.borrows = borrows;
    }

   @Override
    public String toString() {
        return this.getBookName() + " " + this.getPublishingHouse() + " " + this.getPublishmentYear();
    }

    /** Zwraca tylko tytół i autora książki */
    public String getBookName() {
        return "\"" + this.getTitle() + "\" " + this.getAuthor();
    }
    
}


