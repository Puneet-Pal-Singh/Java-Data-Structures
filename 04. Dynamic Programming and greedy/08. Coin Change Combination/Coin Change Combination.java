import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // int[] coins = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // coins[i] = scn.nextInt();
            arr[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        
        // System.out.println(countWays(coins, amt));
        System.out.println(countWays(arr, amt));
    }

    /*
        public static int countWays1(int[] coins, int amt) {
            int[] dp = new int[amt + 1];
            dp[0] = 1;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                for (int i = 1; i < dp.length; i++) {
                    if (i - coin >= 0) {
                        dp[i] += dp[i - coin];
                    }
                }
            }
            return dp[amt];
        }
    */

    public static int countWays(int[] arr, int amt) {
        int[] dp = new int[amt + 1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[amt];
    }

}


/*
        Input--
        4
        2 3 5 6
        7
        
        Output--
        2
        
*/
