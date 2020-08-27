import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
class findDisappearedNumber2{

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        HashSet<Integer> numbers = new HashSet<>();
        int n = nums.length;

        for(int val: nums){
            numbers.add(val);
        }

        for(int i=1; i<=n; i++){
            if(!numbers.contains(i)){
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
    }

    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};

        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }
}