import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        // 1st Way
        
        
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine(); 
        int a = 0, b = 0, c = 0;
        
        for( int col = 0 ; col < str.length() ; col++ ){
            if( str.charAt( col )  == 'a' ){
                a = ( 2 * a ) + 1;
            }
            else if( str.charAt( col )  == 'b' ){
                b = ( 2 * b ) + a;
            }
            else if( str.charAt( col )  == 'c' ){
                c = ( 2 * c ) + b;
            }
        }
        System.out.println( c );
        
        
        // 2nd Way with dp
        
    /*
        Scanner scn = new Scanner(System.in); 
        String str = scn.nextLine(); 
        
        int[][] dp = new int[3][ str.length() + 1 ];
        
        for( int col = 1 ; col < dp[0].length ; col++ ){
            if( str.charAt( col - 1 )  == 'a' ){
                dp[0][col] = 2 * dp[0][ col - 1 ] + 1;
                //------------------------
                dp[1][col] = dp[1][col - 1];
                dp[2][col] = dp[2][col - 1]; 
            }
            else if( str.charAt( col - 1 )  == 'b' ){
                dp[1][col] = 2 * dp[1][ col - 1 ] + dp[0][col - 1];
                //------------------------
                dp[0][col] = dp[0][col - 1];
                dp[2][col] = dp[2][col - 1];
            }
            else if( str.charAt( col - 1 )  == 'c' ){
                dp[2][col] = 2 * dp[2][ col - 1 ] + dp[1][ col - 1 ];
                //------------------------
                dp[0][col] = dp[0][col - 1];
                dp[1][col] = dp[1][col - 1];
            }
        }
        System.out.println( dp[2][ dp[0].length - 1 ] );
    */        
    
    }
}


/*
        Input---
        a b c a b c
        
        Output--
        7

*/