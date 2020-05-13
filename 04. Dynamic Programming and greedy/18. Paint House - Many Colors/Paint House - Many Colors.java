import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int[][] cost = new int[k][n];
        
        for( int col = 0 ; col < n ; col++ ){
            for( int i = 0 ; i < k ; i++ ){
                cost[i][col] = scn.nextInt(); 
            }
        }
        
        int[][] dp = new int[k][n];
        
        int min = Integer.MAX_VALUE ; int smin = Integer.MAX_VALUE ;
        
        for( int i = 0 ; i < k ; i++ ){
            dp[i][0] = cost[i][0];
            // min 
            if( cost[i][0] <= min ){
                smin = min;
                min = cost[i][0];
            }
            else if( cost[i][0] < smin ){ // second min
                smin = cost[i][0];
            }
        }
        
        for( int col = 1 ; col < n ; col++ ){
            int nmin = Integer.MAX_VALUE ; int nsmin = Integer.MAX_VALUE ;
            
            for( int i = 0 ; i < k ; i++ ){
                // find min
                if( min == dp[i][col - 1] ){
                    dp[i][col] = cost[i][col] + smin;
                }
                else{
                    dp[i][col] = cost[i][col] + min;
                }
                
                if( dp[i][col] <= nmin ){
                    nsmin = nmin;
                    nmin = dp[i][col];
                }
                else if( nsmin > dp[i][col] ){
                    nsmin = dp[i][col];
                }
            }
            min = nmin;
            smin = nsmin;
            
            /*
            min = Integer.MAX_VALUE , smin = Integer.MAX_VALUE ;
            for( int i = 0 ; i < k ; i++ ){
                if( dp[i][col] <= min ){
                    smin = min;
                    min = dp[i][col];
                }
                else if( smin > dp[i][col] ){
                    smin = dp[i][col];
                }
            }
            */
        }
        System.out.println( min );
    }
}


/*
        Input---
        
        4 3
        1 5 7
        5 8 4
        3 2 9
        1 2 4
        
        Output---
        
        8

*/