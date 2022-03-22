import java.util.HashMap;
import java.util.List;
public class MyFactoryMap {
    public Imaps<String, List<String>> getMap(String implementation){
        if(implementation.equals("HashMap")){
            return new MyHashMap<String, List<String>>();
        }else if(implementation.equals("LinkedHashMap")){
            return new MyLinkedHashMap<String, List<String>>();
        }else if(implementation.equals("TreeMap")){
            return new MyTreeMap<String,List<String>>();
        }
    return null;
    }
}
