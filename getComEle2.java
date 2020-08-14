// print common element including repeatition

import java.util.HashMap;
class getComEle2{

    public static void main(String[] args){
        int[] a1 = {1,1,2,2,2,3,5};
        int[] a2 = {1,1,1,2,2,4,5};

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int val: a1){
            if(hm.containsKey(val)){
                int of = hm.get(val);
                int nf = of+1;
                hm.put(val, nf);
            }else{
                hm.put(val, 1);
            }
        }

        for(int val: a2){
            if(hm.containsKey(val) && hm.get(val) > 0){
                System.out.print(val + " ");
                int of = hm.get(val);
                int nf = of-1;
                hm.put(val, nf);
            }
        }

        System.out.println();
    }
}