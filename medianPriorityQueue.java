import java.util.PriorityQueue;
import java.util.Collections;
class medianPriorityQueue{

    public static class MedianPriorityQueue{
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue(){
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val){
            if(right.size()>0 && val>right.peek()){
                right.add(val);
            }else{
                left.add(val);
            }

            if(left.size()-right.size() == 2){
                right.add(left.remove());
            }else if(right.size()-left.size() == 2){
                left.add(right.remove());
            }
        }

        public int remove(){
            if(this.size() == 0){
                System.out.println("Queue Underflow");
                return -1;
            }else if(left.size()>= right.size()){
                return left.remove();
            }else{
                return right.remove();
            }

        }

        public int peek(){
            if(this.size() == 0){
                System.out.println("Queue underflow");
                return -1;
            }else if(left.size()>=right.size()){
                return left.peek();
            }else{
                return right.peek();
            }
        }

        public int size(){
            return left.size() + right.size();
        }
    }

    public static void main(String[] args){
        int[] arr = {10,20,30,40,50,60};

        MedianPriorityQueue mpq = new MedianPriorityQueue();
        for(int i=0; i<arr.length; i++){
            mpq.add(arr[i]);
        }

        System.out.println("Median : " +mpq.remove());

    }
}