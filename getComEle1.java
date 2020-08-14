import java.util.HashMap;
class getComEle1{

    public static void main(String[] args){
        int[] a1 = {1,1,2,2,2,3,5};
        int[] a2 = {1,1,1,2,2,4,5};

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<a1.length; i++){
            if(hm.containsKey(a1[i])){
                int of = hm.get(a1[i]);
                int nf = of +1;
                hm.put(a1[i], nf);
            }else{
                hm.put(a1[i], 1);
            }
        }

        for(int val: a2){
            if(hm.containsKey(val)){
                System.out.print(val + " ");
                hm.remove(val);
            }
        }
        System.out.println();
    }
}