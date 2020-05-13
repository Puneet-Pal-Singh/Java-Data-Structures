import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        boolean[][] dp = new boolean[ str.length() ][ str.length() ];
        int len = 0;
        int count = 0;
        
        for( int gap = 0 ; gap < str.length() ; gap++ ){
            
            for( int i = 0 , j = gap ; j < dp[0].length ; i++, j++ ){
                if( gap == 0 ){
                    dp[i][j] = true;
                }else if( gap == 1 ){
                    if( str.charAt( i ) == str.charAt( j ) ){
                        dp[i][j] = true;
                    }
                }else{
                    if( str.charAt( i ) == str.charAt( j ) && dp[i+1][j-1] == true ){
                        dp[i][j] = true; 
                    }
                }
                
                if( dp[i][j] == true ){
                    count++ ;
                }
            }
        }
        System.out.println( count );
    }   
}

/*
        Sample Input
        
        abccbc
        
        Sample Output
        
        9

*/