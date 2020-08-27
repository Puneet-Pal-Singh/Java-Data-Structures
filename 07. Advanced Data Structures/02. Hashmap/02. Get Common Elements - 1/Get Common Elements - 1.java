import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr = new int[n1];
        
        for (int i = 0; i < n1; i++){
            arr[i] = scn.nextInt();
        }
        
        int n2 = scn.nextInt();
        int[] brr = new int[n2];
        for (int i = 0; i < n2; i++){
            brr[i] = scn.nextInt();
        }
        printCE(arr, brr);
    }
    
    public static void printCE(int[] a, int[] b) {
        
        HashMap < Integer, Integer > hm = new HashMap < > ();
        
        for (int i = 0; i < a.length; i++) {
            hm.put(a[i], 1);
        }
        
        for (int i = 0; i < b.length; i++) {
            
            if ( hm.containsKey( b[i] ) ) {
                System.out.println( b[i] );
                hm.remove(b[i]);
            }
        }
    }
}

/*
        Sample Input
        
        9
        5
        5
        9
        8
        5
        5
        8
        0
        3
        
        18
        9
        7
        1
        0
        3
        6
        5
        9
        1
        1
        8
        0
        2
        4
        2
        9
        1
        5
        
        Sample Output
        9
        0
        3
        5
        8

*/