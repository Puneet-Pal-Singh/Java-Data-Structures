import java.io.*;
import java.util.*;

public class Main {
    
    // Comparable is an Interface
    static class pair implements Comparable<pair>{
        int sp; // Start point
        int ep; // End Point
        
        public int compareTo( pair other ){
            if( this.sp != other.sp ){
                return this.sp - other.sp;
            }else{
                return this.ep - other.sp;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pair[] bridges = new pair[ n ];
        
        for( int i = 0 ; i < n ; i++ ){
            pair bridge = new pair();
            bridge.sp = scn.nextInt();
            bridge.ep = scn.nextInt();
            bridges[i] = bridge;
        }
        
        Arrays.sort( bridges );
        int[] dp = new int[ n ];
        dp[0] = 1;
        for( int i = 1 ; i < n ; i++ ){
            int max = 0;
            for( int j = 0 ; j < i ; j++ ){
                if( bridges[i].ep >= bridges[j].ep && max < dp[j] ){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        int ans = dp[0];
        for( int i = 1 ; i < n ; i++ ){
            if( ans < dp[i] ){
                ans = dp[i];
            }
        }
        System.out.println( ans );
    }
}

/*
        Sample Input
        
        10
        10 20
        2 7
        8 15
        17 3
        21 40
        50 4
        41 57
        60 80
        80 90
        1 30
        
        Sample Output
        
        7
*/