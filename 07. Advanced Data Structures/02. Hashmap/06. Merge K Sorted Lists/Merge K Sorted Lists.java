import java.io.*;
import java.util.*;

public class Main {

    public static class pair implements Comparable < pair > {
        ArrayList < Integer > list;
        int idx;

        pair(ArrayList < Integer > list, int idx) {
            this.list = list;
            this.idx = idx;
        }

        public int compareTo(pair other) {
            return this.list.get(this.idx) - other.list.get(other.idx);
        }
    }

    public static ArrayList < Integer > mergeKSortedLists(ArrayList < ArrayList < Integer >> lists) {
        ArrayList < Integer > rv = new ArrayList < > ();

        // write your code here

        PriorityQueue < pair > pq = new PriorityQueue < > ();
        for (int i = 0; i < lists.size(); i++) {
            pq.add(new pair(lists.get(i), 0));
        }

        while (pq.size() > 0) {
            pair cp = pq.remove();
            rv.add(cp.list.get(cp.idx));
            cp.idx++;
            if (cp.idx < cp.list.size()) {
                pq.add(cp);
            }
        }
        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList < ArrayList < Integer >> lists = new ArrayList < > ();
        for (int i = 0; i < k; i++) {
            ArrayList < Integer > list = new ArrayList < > ();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList < Integer > mlist = mergeKSortedLists(lists);
        for (int val: mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}

/*
        Sample Input
        
        4
        5
        10 20 30 40 50
        7
        5 7 9 11 19 55 57
        3
        1 2 3
        2
        32 39
        
        Sample Output
        
        1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57
        
*/