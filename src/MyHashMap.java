// Obtenido de: https://ichi.pro/es/implementacion-de-hashmap-para-java-159042463681115

import java.util.Objects;

public class MyHashMap<K, V> extends Map implements Imaps<K, V>{

    private MapBucket [] mb; //MapBucket
    private int capacity = 10;
    private int size = 10;


    public MyHashMap(Object key, Object value) {
        super(key, value);
        this.mb = new MapBucket[capacity];
    }

    // comienza duplicación de codigo. Luego borrar. ******************************************************************
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


    // termina duplicación de codigo. Luego borrar. ******************************************************************




    /**
     * @param key   Llave del map.
     * @param value contenido del maps.
     */
    @Override
    public void put(Object key, Object value) {

    }

    /**
     * @param key llave del map.
     * @return
     */
    @Override
    public Object get(Object key) {
        return null;
    }

    /**
     * @param key llave del map
     */
    @Override
    public void delete(Object key) {

    }

    /**
     * @return tamaño del map.
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * @param key llave
     * @return true si se compara con llave, false si no lo hace.
     */
    @Override
    public boolean containsKey(K key) {
        int hash = getHashCode(key);
        return !(Objects.isNull(mb[hash]) || Objects.isNull(getEntry(key)));
    }
}
