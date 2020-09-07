import java.util.ArrayList;
import java.util.PriorityQueue;
class mergeKSortedLists {

    private static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;

        Pair(int li, int di, int val){
            this.li = li;
            this.di = di;
            this.val = val;
        }

        public int compareTo(Pair o){
            return this.val-o.val;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<lists.size(); i++){
            Pair np = new Pair(i, 0, lists.get(i).get(0));
            pq.add(np);
        }

        while(pq.size()>0){
            Pair p = pq.remove();
            rv.add(p.val);
            p.di++;

            if(p.di < lists.get(p.li).size()){
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return rv;
    }

    public static void main(String[] args){
        String[] arr = {"10 20 30 40 50", "5 7 9 11 19 55 57", "1 2 3", "32 39"};

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int k = arr.length;
        for(int i=0; i<k; i++){
            ArrayList<Integer> list = new ArrayList<>();

            String[] arr1 = arr[i].split(" ");
            for(int j=0; j<arr1.length; j++){
                list.add(Integer.parseInt(arr1[j]));
            }
            lists.add(list);
        }

        ArrayList<Integer> rv = mergeKSortedLists(lists);
        System.out.println(rv);

    }
}