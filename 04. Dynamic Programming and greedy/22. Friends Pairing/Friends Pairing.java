import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        
        int[] dp = new int[n + 1];
        
        if( n <= 1){
            System.out.println( n );
            return;
        }
        dp[0] = 0;   // Base Case
        dp[1] = 1;
        dp[2] = 2;
        
        for( int i = 3 ; i <= n ; i++ ){
            dp[i] = dp[i - 1] + ( (i - 1) * dp[i - 2] );
        }
        System.out.println( dp[n] );
    }

}

/*
        Input---
        4
        
        Output--
        10
*/