package compulsory;
import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalog {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();
    private Map<String, Object> tags = new HashMap<>();

    //constructors
    public Catalog (){
        this.name=null;
        this.path=null;
    }
    public Catalog(String name, String path){
        this.name=name;
        this.path=path;
    }

    //set
    public void setName(String name){
        this.name=name;
    }
    public void setPath(String path){
        this.path=path;
    }

    //get
    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    //set and get documents
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    //override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(name, catalog.name) &&
                Objects.equals(path, catalog.path) &&
                Objects.equals(items, catalog.items);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, path, items);
    }

    //function for items
    public void add(Item itm) {
        items.add(itm);
    }

    public Item findById(String id) {
        for (Item itm : items) {
            if (itm.getId().equals(id)) {
                return itm;
            }
        }
        return null;
    }

    public void addTag(String name, Item itm){
        tags.put(name, itm);
    }
}
