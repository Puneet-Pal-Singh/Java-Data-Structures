import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int ans = minCostMaze(arr);
        System.out.println(ans);
    }

    public static int minCostMaze(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {

                // last element of row and col
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j];
                }

                // last row
                else if (i == dp.length - 1) {
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                }

                //last column
                else if (j == dp[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                }

                // Rest
                else {
                    int minCost = dp[i][j + 1];
                    if (minCost > dp[i + 1][j]) {
                        minCost = dp[i + 1][j];
                        // int minCost = Math.min( dp[i][j+1], dp[i+1][j] );    
                    }
                    dp[i][j] = minCost + arr[i][j];

                    // one liner
                    // dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
                }
            }
        }
        return dp[0][0];
    }
}


/*
        Input--
        
        6
        6
        0 1 4 2 8 2
        4 3 6 5 0 4
        1 2 4 1 4 6
        2 0 7 3 2 2
        3 1 5 9 2 4
        2 7 0 8 5 1
        
        Output--
        
        23

*/
