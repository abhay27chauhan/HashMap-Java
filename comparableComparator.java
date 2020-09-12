import java.util.ArrayList;
import java.util.Comparator;
class comparableComparator{

    public static class Student implements Comparable<Student>{
        int rno;
        int ht;
        int wt;

        Student(int rno, int ht, int wt){
            this.rno = rno;
            this.ht = ht;
            this.wt = wt;
        }

        public int compareTo(Student o){
            return this.rno - o.rno;
        }

        // for printing
        public String toString(){
            return "Rno = " + this.rno + ", Ht = " + this.ht + ", Wt = " + this.wt;
        }
    }

    public static class StudentHtComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.ht - s2.ht;
        }
    }

    public static class StudentWtComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.wt - s2.wt;
        }
    }

    public static class PriorityQueue<T>{
        ArrayList<T> data;
        Comparator comp;

        public PriorityQueue(){
            data = new ArrayList<>();
            comp = null;
        }

        public PriorityQueue(Comparator comp){
            data = new ArrayList<>();
            this.comp = comp;
        }

        public void swap(int i, int j){
            T ith = data.get(i);
            T jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public boolean isSmaller(int i, int j){
            if(comp == null){
                Comparable ith = (Comparable)data.get(i);
                Comparable jth = (Comparable)data.get(j);

                if(ith.compareTo(jth) < 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                T ith = data.get(i);
                T jth = data.get(j);

                if(comp.compare(ith, jth) < 0){
                    return true;
                }else{
                    return false;
                }
            }
            
        }

        public void add(T val){
            data.add(val);
            upheapify(data.size()-1);
        }

        public void upheapify(int i){
            if(i == 0){
                return;
            }
            int pi = (i-1)/2;

            if(isSmaller(i, pi) == true){
                swap(pi, i);
                upheapify(pi);
            }
        }

        public T remove(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return null;
            }

            swap(0, data.size()-1);
            T val = data.remove(data.size()-1);
            downheapify(0);
            return val;
        }

        public void downheapify(int pi){
            int mini = pi;

            int lci = 2*pi + 1;
            if(lci < data.size() && isSmaller(lci, mini)){
                mini = lci;
            }

            int rci = 2*pi + 2;
            if(rci < data.size() && isSmaller(rci, mini)){
                mini = rci;
            }

            if(mini != pi){
                swap(mini, pi);
                downheapify(mini);
            }
        }

        public T peek(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return null;
            }
            return data.get(0);
        }

        public int size(){
            return data.size();
        }
    }

    public static void main(String[] args){
        int[] arr = {22, 99, 3, 11, 88, 4, 1};
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentWtComparator());

       pq.add(new Student(10, 180, 81));
       pq.add(new Student(2, 185, 85));
       pq.add(new Student(12, 170, 84));
       pq.add(new Student(18, 179, 88));
       pq.add(new Student(7, 182, 82));

        while(pq.size()>0){
            System.out.println(pq.peek());  
            pq.remove();                 
        }

    }
}