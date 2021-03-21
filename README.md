## Compulsory 

    Create an object-oriented model of the problem. You should have at least the following classes: Catalog and two item classes at your choice. Consider using an interface or an abstract class in order to describe the items in a catalog.
    Implement the following methods representing commands that will manage the content of the catalog:
        add: adds a new entry into the catalog;
        list: prints the content of the catalog on the screen;
        play: playback using the native operating system application (see the Desktop class);
        save: saves the catalog to an external file (either as a text or binary, using object serialization);
        load: loads the catalog from an external file. 
    The application will signal invalid data (year, path, etc.) using a custom exception. 
    
## Streams of bytes / characters
● Data may be represented either:–Binary (pdf, png, mp3, etc.) or–Text(txt, xml, json, etc.)
● I/O Streams are responsible with reading/writing data from/in external files.–InputStream, OutputStream → bytes (8 bits)–Reader, Writer → characters (16 bits)
● Depending on their job, streams are:–Primitive: FileReader, StringWriter, etc.–Decorators: BufferedReader, ObjectInputStream, etc.

# The Item class
```python
public abstract class Item implements Serializable {
    private String id;
    private String name;
    private String location; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();
    //constructors, setters and getters 
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
        //override and fingById method
    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}
```
    
# The Catalog class
```python
public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();
    //...public void add(Item item) {
        items.add(item);
    }
    public Item findById(String id) {//...}
}
```
    
# The CatalogUtil class
```python
public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }
    public static Catalog load(String path)throws InvalidCatalogException 
    {//...}
    public static void view(Item item) {Desktop desktop = Desktop.getDesktop();
    //... browse or open, depending of the location type    
}

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    }
}
```

# The Main Class
```python
public class Main {public static void main(String args[]) {
    Main app = new Main();
    app.testCreateSave();
    app.testLoadView();
}
 
private void testCreateSave() {
    Catalog catalog = new Catalog("My Books", "d:/media/catalog.ser");
    var song = new Song("bestSong", ... ); 
    var book  = new Book("bestBook", ... ); 
    catalog.add(song);
    catalog.add(book);
    CatalogUtil.save(catalog);
}

private void testLoadView() {
    Catalog catalog = CatalogUtil.load("d:/java/catalog.ser");
    CatalogUtil.view(catalog.findById("bestSong"));
}
```
