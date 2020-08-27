import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solve(n, num, k);
    }
    
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array,n length of array and k.
    // It should print required output.
    
    public static void solve(int n, int[] arr, int k) {
        //Write your code here
    
        PriorityQueue < Integer > pq = new PriorityQueue < > ();
        int i = 0;
    
        while (pq.size() < k && i < arr.length) {
            pq.add(arr[i]);
            i++;
        }
    
        while (i < arr.length) {
            if (pq.peek() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
            i++;
        }
        int[] KEle = new int[pq.size()];
        i = 0;
    
        while (pq.size() > 0) {
            int ele = pq.remove();
            KEle[i] = ele;
            i++;
        }
    
        for (i = KEle.length - 1; i >= 0; i--) {
            System.out.print(KEle[i] + " ");
        }
    }
}


/*

        Sample Input

        8
        44 -5 -2 41 12 19 21 -6 
        2

        Sample Output
        44 41

*/