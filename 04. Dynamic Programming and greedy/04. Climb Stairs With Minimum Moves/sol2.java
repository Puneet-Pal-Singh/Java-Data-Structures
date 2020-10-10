import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] jumps = new int[n];
        for (int i = 0; i < jumps.length; i++) {
            jumps[i] = scn.nextInt();
        }

        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (jumps[i] > 0) {
                int minjump = Integer.MAX_VALUE;

                for (int j = 1; j <= jumps[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        minjump = Math.min(minjump, dp[i + j]);
                    }
                }
                if (minjump != Integer.MAX_VALUE) {
                    dp[i] = minjump + 1;
                } else {
                    dp[i] = null;
                }
            }
        }
        System.out.println(dp[0]);
    }

}


/* 
        Input--
        10 
        3 3 0 2 1 2 4 2 0 0
        
        Output--
        4
*/
