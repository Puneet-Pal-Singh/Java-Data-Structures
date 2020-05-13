import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int[][] dp = new int[2][n];
        
        dp[0][0] = 0;   // same
        dp[1][0] = k;   // diff
        
        for( int col = 1; col < n ; col++ ){
            dp[0][col] = dp[1][ col - 1 ];
            dp[1][col] = ( dp[0][col - 1] + dp[1][col - 1] ) * ( k - 1 );
        }
        
        System.out.println( dp[0][n - 1] + dp[1][n - 1] );
    }
}   

/*
        Input -- 
        
        8
        3
        
        Output--
        
        3672

*/