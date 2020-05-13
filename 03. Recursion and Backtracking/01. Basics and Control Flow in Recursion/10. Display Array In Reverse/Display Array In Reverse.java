import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for( int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        // displayArrReverse(arr, n - 1); // Pre
        displayArrReverse(arr, 0); // Post
    }
    
    // Pre area
    
   /* public static void displayArrReverse(int[] arr, int idx) {
        if( idx < 0){
            return;
        }
        System.out.println( arr[idx] );
        displayArrReverse( arr, idx - 1);
    }*/
    
    // Post Area
    
    public static void displayArrReverse(int[] arr, int idx) {
        if( idx == arr.length){
            return;
        }
        
        displayArrReverse( arr, idx + 1);
        System.out.println( arr[idx] );
    }
    
}


/*
        Sample Input
        5
        3
        1
        0
        7
        5
        Sample Output
        5
        7
        0
        1
        3
*/