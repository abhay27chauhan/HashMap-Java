import java.util.HashMap;
import java.util.Set;
class highFreqChar{

    public static void main(String[] args){
        HashMap<Character, Integer> hm = new HashMap<>();
        String str = "babcccdbabcccd";

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int val = hm.get(ch);
                hm.put(ch, val+1);
            }else{
                hm.put(ch, 1);
            }
        }

        char mfc = str.charAt(0);
        for(Character key: hm.keySet()){
            if(hm.get(key)> hm.get(mfc)){
                mfc = key;
            }
        }
        System.out.println(mfc);
    } 
}