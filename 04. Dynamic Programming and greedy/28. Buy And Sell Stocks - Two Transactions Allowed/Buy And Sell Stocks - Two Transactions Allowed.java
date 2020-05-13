import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n];
        for( int i = 0; i < n ; i++ ){
            price[i] = scn.nextInt();
        }
        
        int[] left = new int[n];
        int min = price[0];
        
        for( int i = 1 ; i < n ; i++ ){
            if( min > price[i] ){
                min = price[i];
            }
            left[i] = Math.max( left[i - 1], price[i] - min );
        }
        
        int[] right = new int[n];
        int max = price[n - 1];
        
        for( int i = n - 2 ; i >= 0 ; i-- ){
            if( max < price[i] ){
                max = price[i];
            }
            right[i] = Math.max( right[i + 1], max - price[i] );
        }
        
        int profit = left[0] + right[0];
        for( int i = 1; i < n ; i++ ){
            if( profit < left[i] + right[i] ){
                profit = left[i] + right[i];
            }
        }
        System.out.println( profit );
    }
}

/*
        Input---
        
        9
        11 6 7 19 4 1 6 18 4
        
        Output---
        
        30

*/
