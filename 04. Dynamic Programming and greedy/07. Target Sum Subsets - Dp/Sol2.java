import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        System.out.println(targetSumSubset(arr, tar));
    }

    public static boolean targetSumSubset(int[] arr, int tar) {
        // one size greater than array and j
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                // first cell 
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                // first row
                else if (i == 0) {
                    dp[i][j] = false;
                }
                // first column
                else if (j == 0) {
                    dp[i][j] = true;
                }
                //rest
                else {
                    // previous row ans came
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        // arr value less then 1 of dp value
                        int val = arr[i - 1];
                        // if one row ahead go back aand above 
                        if (j >= val) {
                            if (dp[i - 1][j - val] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        // return dp[dp.length - 1][tar];
        return dp[arr.length][tar];
    }
}

/*
        Input--
        5
        4
        2
        7
        1
        3
        10
        
        Output--
        true
*/
