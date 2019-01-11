package pl.mycompany.mylibrary911.utils.converters;

import java.util.ArrayList;
import pl.mycompany.mylibrary911.database.models.Book;
import pl.mycompany.mylibrary911.modelFX.BookFX;

/**
 * Klasa służąca do konwertowania obiektów Book i BookFX
 *
 * @author Aleksander Szepelak
 */
public class BookConverter {
    
      /** Metoda konwertująca BookFX na zwykły Book */
    public static Book toBook(BookFX bookFX) {
        Book book = new Book();
        
        book.setIdBook(bookFX.getIdBook().getValue());
        book.setTitle(bookFX.getTitle().getValue());
        book.setAuthor(bookFX.getAuthor().getValue());
        book.setPublishingHouse(bookFX.getPublishingHouse().getValue());
        book.setPublishmentYear(bookFX.getPublishmentYear().getValue());
        book.setBorrowed(bookFX.getBorrowed().getValue());
        book.setBorrows(bookFX.getBorrows().getValue());

        return book;
    }
    
      /** Metoda konwertująca Book na BookFX */
    public static BookFX toBookFX(Book book) {
        BookFX bookFX = new BookFX();
        
          bookFX.setIdBook(book.getIdBook());
          bookFX.setTitle(book.getTitle());
          bookFX.setAuthor(book.getAuthor());
          bookFX.setPublishingHouse(book.getPublishingHouse());
          bookFX.setPublishmentYear(book.getPublishmentYear());
          bookFX.setBorrowed(book.isBorrowed());
          bookFX.setBorrows(book.getBorrows());

        return bookFX;
    }
    
    /** Metoda konwertująca liste książek(Book) na BookFX */
    public static ArrayList<BookFX> toBookFXList(ArrayList<Book> books) {
        ArrayList<BookFX> booksFX = new ArrayList<BookFX>();
        
        for(Book book : books) {
            BookFX bookFX = BookConverter.toBookFX(book);
            booksFX.add(bookFX);
        }
        return booksFX;
    }
    
}
