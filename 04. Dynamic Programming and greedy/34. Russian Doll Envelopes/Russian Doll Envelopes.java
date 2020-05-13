import java.io.*;
import java.util.*;

public class Main {

    // Comparable is an Interface
    static class pair implements Comparable<pair>{
        int w; // Start point
        int h; // End Point
        
        public int compareTo( pair other ){
            if( this.w != other.w ){
                return this.w - other.w;
            }else{
                return this.h - other.h;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pair[] envelopes = new pair[ n ];
        
        for( int i = 0 ; i < n ; i++ ){
            pair env = new pair();
            env.w = scn.nextInt();
            env.h = scn.nextInt();
            envelopes[i] = env;
        }
        
        Arrays.sort( envelopes );
        int[] dp = new int[ n ];
        dp[0] = 1;
        for( int i = 1 ; i < n ; i++ ){
            int max = 0;
            for( int j = 0 ; j < i ; j++ ){
                if( envelopes[i].h >= envelopes[j].h && max < dp[j] ){
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
        
        11
        17 5
        26 18
        25 34
        48 84
        63 72
        42 86
        9 55
        4 70
        21 45
        68 76
        58 51
        
        Sample Output
        
        5

*/