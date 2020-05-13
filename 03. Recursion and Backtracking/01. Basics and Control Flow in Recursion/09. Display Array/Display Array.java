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
        // displayArr(arr, 0);
        displayArr(arr, arr.length - 1);
    }

    //Pre Area
    
    /*public static void displayArr(int[] arr, int idx){
        if( idx == arr.length ){
            return;
        }
        System.out.println( arr[idx] );
        displayArr( arr, idx + 1);
    }*/
    
    // Post Area
    
    public static void displayArr(int[] arr, int idx){
        if( idx < 0 ){
            return;
        }
        displayArr( arr, idx - 1);
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
        
        3
        1
        0
        7
        5
        
        Default case Output---
        
        2
        4
        6
        1
        3
        6
        2
        5
        5
        10
        10
        9
        5
        6
        1
        8

*/