import java.io.*;
import java.util.*;

public class Main {

    public static class MedianPriorityQueue {
        PriorityQueue < Integer > left;
        PriorityQueue < Integer > right;

        public MedianPriorityQueue() {
            left = new PriorityQueue < > (Collections.reverseOrder());
            right = new PriorityQueue < > ();
        }

        public void add(int val) {
            // write your code here
            
            if (left.size() == right.size()) {
                if (left.size() == 0 || left.peek() > val) {
                    left.add(val);
                } else {
                    right.add(val);
                }
            } else if (left.size() > right.size()) {
                if (left.peek() > val) {
                    left.add(val);
                    right.add(left.remove());
                } else {
                    right.add(val);
                }
            } else {
                // right is larger in size
                if (right.peek() < val) {
                    right.add(val);
                    left.add(right.remove());
                } else {
                    left.add(val);
                }
            }
        }

        public int remove() {           // remove Median
            // write your code here
            
            if (left.size() + right.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }
        }

        public int peek() {             // get Median
            // write your code here
            if (left.size() + right.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        public int size() {
            // write your code here
            return left.size() + right.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueue qu = new MedianPriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}


/*
        Sample Input
        
        add 10
        add 20
        add 30
        add 40
        peek
        add 50
        peek
        remove
        peek
        remove
        peek
        remove
        peek
        remove
        peek
        quit
        
        Sample Output
        
        20
        30
        30
        20
        20
        40
        40
        10
        10
        50

*/