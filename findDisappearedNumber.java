import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
class findDisappearedNumber{

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n= nums.length;
        for(int val: nums){
            if(hm.containsKey(val)){
                int of = hm.get(val);
                int nf = of+1;
                hm.put(val, nf);
            }else{
                hm.put(val,1);
            }
        }
        
        for(int i=1; i<=n; i++){
            if(!hm.containsKey(i)){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};

        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }
}