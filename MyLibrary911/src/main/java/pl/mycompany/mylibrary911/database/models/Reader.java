package pl.mycompany.mylibrary911.database.models;
// Generated 2019-01-10 13:46:39 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Bazodanowy model danych klasy Reader
 * 
 * Reader generated by hbm2java modified by Aleksander Szepelak
 */
public class Reader  implements java.io.Serializable {

    private Integer idReader;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private Set borrows = new HashSet(0);

    public Reader() {
    }

	
    public Reader(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
     public Reader(String firstName, String lastName, Integer phoneNumber) {
       this.setFirstName(firstName);
       this.setLastName(lastName);
       this.setPhoneNumber(phoneNumber);
    }
    public Reader(String firstName, String lastName, Integer phoneNumber, Set borrows) {
       this.setFirstName(firstName);
       this.setLastName(lastName);
       this.setPhoneNumber(phoneNumber);
       this.setBorrows(borrows);
    }
   
    public Integer getIdReader() {
        return this.idReader;
    }
     public void setIdReader(Integer idReader) {
        this.idReader = idReader;
    }
     
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumber) {
            this.phoneNumber = phoneNumber;
    }
    
    public Set getBorrows() {
        return this.borrows;
    }
    public void setBorrows(Set borrows) {
        this.borrows = borrows;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }

}


