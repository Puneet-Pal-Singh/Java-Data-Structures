import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here 
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for( int i = 0; i < n ; i++ ){
            arr[i] = scn.nextInt();
        }
        
        int[] dp = new int[n];
        dp[0] = 1;
        for( int i = 1; i < n ; i++ ){
            dp[i] = 1;
            int prevMax = 0;
            for( int j = 0; j < i ; j++ ){
                if( arr[i] >= arr[j] && prevMax < dp[j] ){
                    prevMax = dp[j];
                }
            }
            //if( prevmax + 1 > dp[i] ){
                dp[i] = prevMax + 1;
            //}
        }
        int max = dp[0];
        for( int i = 1; i < n ; i++ ){
            if( dp[i] > max ){
                max = dp[i];
            }
        }System.out.println(max);
    }

}

/*
        Input--
        
        10
        10 22 9 33 21 50 41 60 80 1
        
        Output--
        
        6
*/