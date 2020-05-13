import java.io.*;
import java.util.*;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        if( n == 0 || k == 0 ) 
        {
            System.out.println(0);
            return;
        }
        
        long [][] dp = new long[k+1][n+1];
        
        for( int i = 1; i <= k; i++ )
        {
            for( int j = i; j <= n ; j++ )
            {
                if( i == j || i == 1 ){
                    dp[i][j] = 1;
                }
                else{ 
                    dp[i][j] = dp[i-1][j-1] + i * dp[i][j-1];
                }
            }
        }
        System.out.println( dp[k][n] );
    }
}


/*
    Input---
    4
    3
    
    Output---
    6

*/