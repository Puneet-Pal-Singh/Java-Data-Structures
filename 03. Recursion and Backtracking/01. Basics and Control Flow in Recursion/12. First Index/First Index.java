import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];;

        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int d = scn.nextInt();

        int fi = firstIndex(arr, 0, d);
        System.out.print(fi);
    }

    public static int firstIndex(int[] arr, int idx, int x) {

        if (idx == arr.length) {
            return -1;
        }
        
        /*
        int fiisa = firstIndex(arr, idx + 1, x);
        if( arr[idx] == x ){
            return idx;  
        } else {
            return fiisa;
        }
        */
        
        // Better Approach
        if (arr[idx] == x) {
            return idx;
        } else {
            int fiisa = firstIndex(arr, idx + 1, x);
            return fiisa;
        }

    }
}    

    /*
            Sample Input--
            
            6
            15
            11
            40
            4
            4
            9
            4
            
            Sample Output---
            
            3
    */
