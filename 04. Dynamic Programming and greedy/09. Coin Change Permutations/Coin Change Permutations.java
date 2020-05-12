import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int[] coins = new int[n];
        for( int i = 0 ; i < n ; i++ ){
            coins[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        System.out.println( countWays( coins , amt ) );
    }
    
    public static int countWays( int[] coins, int amt ){
        int[] dp = new int[ amt + 1 ];
        dp[0] = 1;
        for( int i = 1; i < dp.length ; i++ ){
            for( int j = 0; j < coins.length ; j++ ){
                int coin = coins[j];
                if( i - coin >= 0 ){
                    dp[i] += dp[ i - coin ];
                }
            }
        }
        return dp[amt];
    }
}


/*
        Input--
        4
        2
        3
        5
        6
        7
        
        Output--
        5
        
*/