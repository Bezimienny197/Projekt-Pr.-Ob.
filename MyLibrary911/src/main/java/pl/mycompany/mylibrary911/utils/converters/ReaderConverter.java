package pl.mycompany.mylibrary911.utils.converters;

import java.util.ArrayList;
import pl.mycompany.mylibrary911.database.models.Reader;
import pl.mycompany.mylibrary911.modelFX.ReaderFX;

/**
 * Klasa służąca do konwertowania obiektów Reader i ReaderFX
 *
 * @author Aleksander Szepelak
 */
public class ReaderConverter {
    
      /** Metoda konwertująca ReaderFX na zwykły Reader */
    public static Reader toReader(ReaderFX readerFX) {
        Reader reader = new Reader();
        
        reader.setIdReader(readerFX.getIdReader().getValue());
        reader.setFirstName(readerFX.getFirstName().getValue());
        reader.setLastName(readerFX.getLastName().getValue());
        reader.setPhoneNumber(readerFX.getPhoneNumber().getValue());
        reader.setBorrows(readerFX.getBorrows().getValue());

        return reader;
    }
    
      /** Metoda konwertująca Reader na ReaderFX */
    public static ReaderFX toReaderFX(Reader reader) {
        ReaderFX readerFX = new ReaderFX();
        
        readerFX.setIdReader(reader.getIdReader());
        readerFX.setFirstName(reader.getFirstName());
        readerFX.setLastName(reader.getLastName());
        readerFX.setPhoneNumber(reader.getPhoneNumber());
        readerFX.setBorrows(reader.getBorrows());

        return readerFX;
    }
    
    /** Metoda konwertująca liste czytelników(Reader) na ReaderFX */
    public static ArrayList<ReaderFX> toReaderFXList(ArrayList<Reader> readers) {
        ArrayList<ReaderFX> readersFX = new ArrayList<ReaderFX>();
        
        for(Reader reader : readers) {
            ReaderFX readerFX = ReaderConverter.toReaderFX(reader);
            readersFX.add(readerFX);
        }
        return readersFX;
    }
    
}
