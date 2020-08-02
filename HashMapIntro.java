import java.util.Set;
import java.util.HashMap;
class HashMapIntro{
    
    public static void main(String[] args){
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 135);
        hm.put("China", 200);
        hm.put("Pak", 30);
        hm.put("Us", 20);
        hm.put("Uk", 10);

        System.out.println(hm);

        hm.put("Nigeria", 5);
        hm.put("Us", 25);

        System.out.println(hm);

        System.out.println(hm.get("India"));
        System.out.println(hm.get("Utopia"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Utopia"));

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for(String key: keys){
            Integer val = hm.get(key);
            System.out.println(key + " " + val);
        }
    }
}