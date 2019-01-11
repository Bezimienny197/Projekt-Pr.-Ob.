package pl.mycompany.mylibrary911.utils;

import java.util.ResourceBundle;

/**
 * Klasa służąca do obsługi ResourceBundles
 *
 * @author Alesander Szepelak
 */
public class ResourceBundlesUtils {
    
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("bundles.messages");

    public static ResourceBundle getResourceBundle() {
        return BUNDLE;
    }
    
    public static String getString(String string) {
        return getResourceBundle().getString(string);
    }
    
}
