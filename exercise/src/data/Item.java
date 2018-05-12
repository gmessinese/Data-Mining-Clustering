package data;
import java.util.Set;

public abstract class Item {
    protected Attribute attribute;
    protected Object value;
  
    public Item(Attribute attribute, Object value) {
        this.attribute = attribute;
        this.value = value;
    }
  
    Attribute getAttribute() {
        return attribute;
    }
  
    Object getValue() {
        return value;
    }
  
    public String toString() {
        return value.toString(); // To verify
    }
  
    abstract double distance(Object a);
  
    public void update(Data data, Set<Integer> clusteredData) {
        value = data.computePrototype(clusteredData, attribute);
    }
}