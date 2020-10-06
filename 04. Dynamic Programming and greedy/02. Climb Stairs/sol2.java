import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // Recursion
        // int ans = countPathsR(n);

        // Memoisation
        // int ans = countPaths(n, new int[n + 1]);
        // int[] strg = new int[n + 1];

        // Tabulation
        int ans = countPathsTab(n);

        System.out.println(ans);
    }

    //Simple Recursion

    public static int countPathsR(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        // System.out.println("Hello" + n);
        int nm1 = countPathsR(n - 1);
        int nm2 = countPathsR(n - 2);
        int nm3 = countPathsR(n - 3);
        int ans = nm1 + nm2 + nm3;

        return ans;
    }

    // Memoisation

    public static int countPaths(int n, int[] strg) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (strg[n] > 0) {
            return strg[n];
        }

        // System.out.println("Hello" + n);
        int nm1 = countPaths(n - 1, strg);
        int nm2 = countPaths(n - 2, strg);
        int nm3 = countPaths(n - 3, strg);
        int ans = nm1 + nm2 + nm3;

        strg[n] = ans;
        return ans;
    }

    // Tabulation
    public static int countPathsTab(int n) {

        /*
        int[] strg = new int[n + 1];
        strg[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            if (i - 1 >= 0) {
                count += strg[i - 1];
            }
            if (i - 2 >= 0) {
                count += strg[i - 2];
            }
            if (i - 3 >= 0) {
                count += strg[i - 3];
            }
            strg[i] = count;
        }
        
        return strg[n];
       */

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

}
