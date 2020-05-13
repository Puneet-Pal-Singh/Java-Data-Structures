import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        if(n<2)
        {
            System.out.println( n );
            return;
        }
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for( int i = 3 ; i <= n ; i++ ){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println( dp[n] );
    }
}

/*  
        Input---
        8
        
        Output---
        34
*/