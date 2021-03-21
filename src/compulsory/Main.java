package compulsory;
import java.awt.*;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidCatalogException, IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources", "d:/java/catalog.ser");
        Item itm = new Item("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        var song = new Item("best song", "Song 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        var book  = new Item("best book", "Book 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        catalog.add(song);
        catalog.add(book);
        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("d:/java/catalog.ser");
        Item itm = catalog.findById("java1");
        CatalogUtil.view(itm);
    }

}
