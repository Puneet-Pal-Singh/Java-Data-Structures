import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] gold = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                gold[i][j] = scn.nextInt();
            }
        }
        int ans = maxGold(gold);
        System.out.println(ans);
    }

    public static int maxGold(int[][] gold) {

        int[][] dp = new int[gold.length][gold[0].length];

        // loop of j
        // as traversing from right col to left col
        for (int j = dp[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < dp.length; i++) {

                // last Column
                if (j == dp[0].length - 1) {
                    dp[i][j] = gold[i][j];
                }

                // First Row
                else if (i == 0) {
                    int max = Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                    dp[i][j] = gold[i][j] + max;
                }

                // Last Row
                else if (i == dp.length - 1) {
                    int max = Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                    dp[i][j] = gold[i][j] + max;
                }

                // Rest
                else {
                    int max = Math.max(dp[i - 1][j + 1], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));
                    dp[i][j] = gold[i][j] + max;
                }
            }
        }

        // First column
        int ans = dp[0][0];
        for (int i = 1; i < dp.length; i++) {
            // moving in row and checking max
            if (dp[i][0] > ans) {
                ans = dp[i][0];
            }
        }
        return ans;
    }

}


/*
        Input---
        
        6
        6
        0 1 4 2 8 2
        4 3 6 5 0 4
        1 2 4 1 4 6
        2 0 7 3 2 2
        3 1 5 9 2 4
        2 7 0 8 5 1
        
        Output---
        
        33
*/
