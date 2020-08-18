// add & remove - logn;
// peek - O(1)
// defaut - < -> High Priority
import java.util.PriorityQueue;
import java.util.Collections;
class priorityQueue{

    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = {22, 99, 3, 11, 88, 4, 1};

        for(int val: arr){
            pq.add(val);       // nlogn
        }

        for(int val: arr){
            System.out.println(pq.peek());  
            pq.remove();                       // nlogn
        }
    }
}