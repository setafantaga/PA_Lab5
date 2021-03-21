package compulsory;
import java.util.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Item implements Serializable{
    private String id;
    private String name;
    private String location;
    private Map<String, Object> tags = new HashMap<>();

    //constructors
    public Item(){
        this.id=null;
        this.name=null;
        this.location=null;
    }
    public Item(String id, String name, String location){
        this.id=id;
        this.name=name;
        this.location=location;
    }

    //setters and getters
    public void setId(String id){
        this.id=id;
    }
    public String getId(String id){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location){
        this.location=location;
    }
    public String getLocation() {
        return location;
    }

    //add tags
    public void addTags(String key, String value) {
        this.tags.put(key, value);
    }

    //Override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(location, item.location) &&
                Objects.equals(tags, item.tags);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, tags);
    }

    Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
