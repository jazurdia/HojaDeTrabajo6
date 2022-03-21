import java.util.LinkedList;
import java.util.List;

/**
 * Obtenido de : https://ichi.pro/es/implementacion-de-hashmap-para-java-159042463681115
 */

public class MapBucket {

    private List<Map> entries;

    public MapBucket(){
        if (entries == null){
            entries = new LinkedList<>();
        }
    }

    public List<Map> getEntries(){
        return entries;
    }

    public void addEntry(Map entry){
        this.entries.add(entry);
    }

    public void removeEntry(Map entry){
        this.entries.remove(entry);
    }


}
