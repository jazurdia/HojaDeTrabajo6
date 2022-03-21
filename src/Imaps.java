public interface Imaps <K,V>{

    /**
     *
     * @param key Llave del map.
     * @param value contenido del maps.
     */
    public void put(K key, V value);

    /**
     *
     * @param key llave del map.
     * @return
     */
    public V get(K key);

    /**
     *
     * @param key llave del map
     */
    public void delete (K key);

    /**
     *
     * @return tamaño del map.
     */
    public int size();

}
