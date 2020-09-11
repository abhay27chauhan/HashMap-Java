import java.util.LinkedList;
import java.util.ArrayList;
class writeHashMap{

    public static class HashMap<K, V> {
        
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap(){
            initbuckets(4);
            size = 0;
        }

        public void initbuckets(int N){
            buckets = new LinkedList[N];
            for(int bi = 0; bi<buckets.length; bi++){
                buckets[bi] = new LinkedList<>();
            }
        }

        public void put(K key, V value){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);

            if(di != -1){
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }else{
                HMNode node = new HMNode(key, value);
                buckets[bi].add(node);
                size++;
            }

            double lambda = size*1.0/buckets.length;
            if(lambda > 2.0){
                rehash();
            }
        }

        public void rehash(){
            LinkedList<HMNode>[] oba = buckets;

            initbuckets(oba.length * 2);
            size = 0;
            for(int i=0; i<oba.length; i++){
                for(HMNode node: oba[i]){
                    put(node.key, node.value);
                }
            }
        }

        public int hashfn(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        public int getIndexWithinBucket(K key, int bi){
            int di = 0;
            for(HMNode node: buckets[bi]){
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }

            return -1;
        }

        public V get(K key){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);

            if(di != -1){
                return buckets[bi].get(di).value;
            }else{
                return null;
            }
        }

        public boolean containsKey(K key){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);

            if(di != -1){
                return true;
            }else{
                return false;
            }
        }

        public V remove(K key){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);

            if(di != -1){
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++){
                for(HMNode node: buckets[i]){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public int size(){
            return size;
        }
    }

    public static void main(String[] args){
        HashMap<String, Integer> hm = new HashMap();

        hm.put("India", 135);
        hm.put("China", 200);
        hm.put("Pak", 30);
        hm.put("Us", 20);
        hm.put("Uk", 10);

        hm.put("Nigeria", 5);
        hm.put("Us", 25);
        
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Utopia"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Utopia"));

        ArrayList<String> keys = hm.keySet();
        System.out.println(keys);

        for(String key: keys){
            Integer val = hm.get(key);
            System.out.println(key + " " + val);
        }
        
    }
}