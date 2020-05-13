import java.io.*;
import java.util.*;

public class Main{

    public static void subArrays( int[] arr ){
        for( int i = 0 ; i < arr.length ; i++ ){
            for( int j = i ; j < arr.length ; j++ ){
                for( int k = i ; k <= j ; k++ ){
                    System.out.print( arr[k] + "\t");
                }
                System.out.print("\n");
            }
       }
    // System.out.println();
    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        subArrays( arr );
    }
}

/*
        Input--
        
        3
        10 20 30
        
        Output--
        
        10
        10  20
        10  20  30
        20
        20  30
        30
*/