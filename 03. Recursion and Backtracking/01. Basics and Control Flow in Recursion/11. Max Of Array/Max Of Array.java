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
        int maxVal = maxOfArray(arr,0);
        
        System.out.println(maxVal);
    }
    
    // Post Area
    
    public static int maxOfArray(int[] arr, int idx){
        
        if( idx == arr.length - 1){
            return arr[idx];
        }
        
        int misa = maxOfArray( arr, idx + 1);       //Max in Smaller Array
        if( misa > arr[idx] ){
            return misa;
        }
        else{
            return arr[idx];
        }
    }
}


// This is done using Post Area
/*
        
        Sample Input---
        
        6
        15
        30
        40
        4
        11
        9
        
        Sample Output---
        
        40
        
        Default Case Output---
        
        2146478707

*/
