import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        int[][] dp = new int[ str.length() ][ str.length() ];
        
        for( int gap = 0 ; gap < dp[0].length ; gap++ ){
            for( int i = 0 , j = gap ; j < dp[0].length ; i++, j++ ){
                if( gap == 0 ){
                    dp[i][j] = 1;
                }else if( gap == 1 ){
                    if( str.charAt( i ) == str.charAt( j ) ){
                        dp[i][j] = 3;
                    }
                    else{
                        dp[i][j] = 2;
                    }
                }else{
                    if( str.charAt( i ) == str.charAt( j ) ){
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1; 
                    }else{
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                    }
                }
            }
        }
        System.out.println( dp[0][ dp[0].length - 1 ] );
    }
}



/*
        Input---
        
        ccbbgd
        
        Output---
        
        8

*/