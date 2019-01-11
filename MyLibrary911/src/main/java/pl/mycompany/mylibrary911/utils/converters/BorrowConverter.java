package pl.mycompany.mylibrary911.utils.converters;

import java.util.ArrayList;
import pl.mycompany.mylibrary911.database.models.Borrow;
import pl.mycompany.mylibrary911.modelFX.BorrowFX;

/**
 * Klasa służąca do konwertowania obiektów Borrow i BorrowFX
 *
 * @author Aleksander Szepelak
 */
public class BorrowConverter {
    
      /** Metoda konwertująca BorrowFX na zwykły Borrow */
    public static Borrow toBorrow(BorrowFX borrowFX) {
        Borrow borrow = new Borrow();
        
        borrow.setIdBorrow(borrowFX.getIdBorrow().getValue());
        borrow.setBook(borrowFX.getBook().getValue());
        borrow.setReader(borrowFX.getReader().getValue());
        borrow.setDateOfRental(borrowFX.getDateOfRental().getValue());
        borrow.setDateOfReturn(borrowFX.getDateOfReturn().getValue());

        return borrow;
    }
    
      /** Metoda konwertująca Borrow na BorrowFX */
    public static BorrowFX toBorrowFX(Borrow borrow) {
        BorrowFX borrowFX = new BorrowFX();
        
        borrowFX.setIdBorrow(borrow.getIdBorrow());
        borrowFX.setBook(borrow.getBook());
        borrowFX.setReader(borrow.getReader());
        borrowFX.setDateOfRental(borrow.getDateOfRental());
        borrowFX.setDateOfReturn(borrow.getDateOfReturn());

        return borrowFX;
    }
    
    /** Metoda konwertująca liste wypożyczeń(Borrow) na BorrowFX */
    public static ArrayList<BorrowFX> toBorrowFXList(ArrayList<Borrow> borrows) {
        ArrayList<BorrowFX> borrowsFX = new ArrayList<BorrowFX>();
        
        for(Borrow borrow : borrows) {
            BorrowFX borrowFX = BorrowConverter.toBorrowFX(borrow);
            borrowsFX.add(borrowFX);
        }
        return borrowsFX;
    }
    
}
