import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0 ; i < n; i++ ){
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        System.out.println( targetSumSubset( arr,tar ) );
    }
     
    public static boolean targetSumSubset( int[] arr, int tar ){
        boolean[][] dp = new boolean[ arr.length + 1 ][ tar + 1 ];
        dp[0][0] = true;
        for( int i = 1; i < dp.length ; i++ ){
            for(int j = 0; j < dp[0].length ; j++ ){
                
                //element says no
                dp[i][j] = dp[i - 1][ j ];
                
                //element says yes
                // if( dp[i][j] == false && j - arr[ i - 1] >=0 && dp[ i - 1 ][ j - arr[ i - 1] ] == true ){
                
                if( j - arr[ i - 1] >=0 && dp[ i - 1 ][ j - arr[ i - 1] ] == true ){
                    dp[i][j] = true;
                }
            }
        }
        return dp[ dp.length - 1 ][ tar ];
    }    
}

/*
        Input--
        5
        4
        2
        7
        1
        3
        10
        
        Output--
        true
*/