package compulsory;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class InvalidCatalogException extends Exception{
    public InvalidCatalogException(String message)
    {
        super(message);
    }
}

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        if (path == null) {
            throw new InvalidCatalogException("Cannot load catalog");
        }
        return null;
    }

    public static void view(Item itm) {
        Desktop desktop = Desktop.getDesktop();
        //… browse or open, depending of the location type
    }
}
