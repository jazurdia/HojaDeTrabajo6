import java.util.Objects;

public class MyLinkedHashMap<K, V> extends Map implements Imaps<K, V> {

    private MapBucket [] mb; //MapBucket
    private int capacity = 10;
    private int size = 0;

    public MyLinkedHashMap(Object key, Object value) {
        super(key, value);
        this.mb = new MapBucket[capacity];
    }

    public MyLinkedHashMap() {

    }

    @Override
    public void put(K key, V value) {
        if(containsKey(key)){
            Map entry = getEntry(key);
            entry.setValue(value);
        }else{
            int hash = getHashCode(key);
            if(mb[hash] == null){
                mb[hash] = new MapBucket();
            }
            mb[hash].addEntry(new Map(key, value));
        }
    }

    @Override
    public V get(K key) {
        return containsKey(key) ? (V) getEntry(key).getValue() : null;
    }

    @Override
    public void delete(K key) {
        if(containsKey(key)){
            int hash = getHashCode(key);
            mb[hash].removeEntry(getEntry(key));
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        int hash = getHashCode(key);
        return !(Objects.isNull(mb[hash]) || Objects.isNull(getEntry(key)));
    }

    //***********************************************************************//
    public int getHashCode(K key){
        return (key.hashCode() & 0xfffffff) % capacity;
    }

    public Map getEntry(K key){
        int hash = getHashCode(key);
        for(int i = 0; i < mb[hash].getEntries().size(); i++){
            Map mymap = mb[hash].getEntries().get(i);
            if(mymap.getKey().equals(key)){
                return mymap;
            }
        }
        return null;
    }



}
