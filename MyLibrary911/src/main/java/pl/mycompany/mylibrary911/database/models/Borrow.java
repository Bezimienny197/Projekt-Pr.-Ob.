package pl.mycompany.mylibrary911.database.models;
// Generated 2019-01-10 13:46:39 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Borrow generated by hbm2java
 */
public class Borrow  implements java.io.Serializable {


     private Integer idBorrow;
     private Book book;
     private Reader reader;
     private Date dateOfRental;
     private Date dateOfReturn;

    public Borrow() {
    }

    public Borrow(Book book, Reader reader, Date dateOfRental, Date dateOfReturn) {
       this.book = book;
       this.reader = reader;
       this.dateOfRental = dateOfRental;
       this.dateOfReturn = dateOfReturn;
    }
   
    public Integer getIdBorrow() {
        return this.idBorrow;
    }
    
    public void setIdBorrow(Integer idBorrow) {
        this.idBorrow = idBorrow;
    }
    public Book getBook() {
        return this.book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    public Reader getReader() {
        return this.reader;
    }
    
    public void setReader(Reader reader) {
        this.reader = reader;
    }
    public Date getDateOfRental() {
        return this.dateOfRental;
    }
    
    public void setDateOfRental(Date dateOfRental) {
        this.dateOfRental = dateOfRental;
    }
    public Date getDateOfReturn() {
        return this.dateOfReturn;
    }
    
    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }




}


