import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner( System.in );
        String a = scn.nextLine();
        String b = scn.nextLine();
        
        if( a.length() == 0 || b.length() == 0 ){
            System.out.println(0);
            return;
        }
        
        int[][] dp = new int[a.length() + 1 ][b.length() + 1];
        for( int i = dp.length - 2 ; i >= 0 ; i-- ){
            for( int j = dp[0].length-2 ; j >=0 ; j-- ){
                if( a.charAt(i) == b.charAt(j) ){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    int max = Math.max( dp[i][j+1], dp[i+1][j] );
                    dp[i][j] = max;
                }
            }
        }
        System.out.println( dp[0][0] );
    }   
    
}
/*
        Input---
        
        abcd
        aebd
        
        Output--
        3
*/