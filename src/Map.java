import java.util.List;

/**
 * Obtenido de : https://ichi.pro/es/implementacion-de-hashmap-para-java-159042463681115
 */
public class Map <K,V> {

    private K key;
    private V value;
    private List l;

    public Map (K key, V value){
        this.key = key;
        this.value = value;
    }

    public Map() {

    }

    //setters and getters
    public K getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }

    public void setKey(K key){
        this.key = key;
    }

    public void setValue(V value){
        this.value = value;
    }
}
