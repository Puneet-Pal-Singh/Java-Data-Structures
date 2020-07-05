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
            if (hm.containsKey(a[i]))
                // int val = hm.get( a[i] );
                hm.put(a[i], hm.get(a[i]) + 1);
            else
                hm.put(a[i], 1);
        }
        
        for (int i = 0; i < b.length; i++) {
            if (hm.containsKey(b[i])) {
                System.out.println(b[i]);
                int val = hm.get(b[i]);
                val--;
               
                if (val > 0){
                    hm.put(b[i], val);
                }else{
                    hm.remove(b[i]);
                }
            }
        }
    }
}

/*
        Sample Input
        
        7
        1
        1
        2
        2
        2
        3
        5
        
        7
        1
        1
        1
        2
        2
        4
        5
        
        Sample Output
        1
        1
        2
        2
        5
*/