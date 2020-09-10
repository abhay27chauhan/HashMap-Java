// HOP -> parent should have higher priority than its children (smaller in value than its children);
// HOP helps to achieve peek operation in O(1);
// CBT -> binary tree with n-1 levels completely filled and the nth level is allowed to filled from left to right;
// CBT property helps to achieve add and remove operation in O(logn);
// lci (left child idx) -> 2*pi +1;
// rci (right child idx) -> 2*pi +2;
// pi  (parent idx) -> (ci-1)/2;
// CBT helps to use the implementation via arraylist;

import java.util.ArrayList;
class writePriorityQueue{

    public static class PriorityQueue{
        ArrayList<Integer> data;

        public PriorityQueue(){
            data = new ArrayList<>();
        }

        public void add(int val){
            data.add(val);
            upheapify(data.size()-1);
        }

        public void upheapify(int i){
            if(i == 0){
                return;
            }

            int pi = (i-1)/2;
            if(data.get(pi)> data.get(i)){
                // swap
                int ith = data.get(i);
                int jth = data.get(pi);
                data.set(i, jth);
                data.set(pi, ith);

                upheapify(pi);
            }
        }

        public int remove(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            // swap
            int ith = data.get(0);
            int jth = data.get(data.size()-1);
            data.set(0, jth);
            data.set(size()-1, ith);

            int val = data.remove(data.size()-1);
            downheapify(0);
            return val;
        }

        public void downheapify(int pi){
            int mini = pi;

            int li = 2*pi + 1;
            if(li <data.size() && data.get(li)< data.get(mini)){
                mini = li;
            }

            int ri = 2*pi + 2;
            if(ri <data.size() && data.get(ri)< data.get(mini)){
                mini = ri;
            }

            if(mini != pi){
                int ith = data.get(pi);
                int jth = data.get(mini);
                data.set(pi, jth);
                data.set(mini, ith);

                downheapify(mini);
            }
        }

        public int peek(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size(){
            return data.size();
        }
    }

    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue();

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