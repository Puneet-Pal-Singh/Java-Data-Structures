import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        /*
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int[] values = new int[n];
            String str1 = br.readLine();
            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(str1.split(" ")[i]);
            }

            int[] wts = new int[n];
            String str2 = br.readLine();
            for (int i = 0; i < n; i++) {
                wts[i] = Integer.parseInt(str2.split(" ")[i]);
            }

            int cap = Integer.parseInt(br.readLine());

        */

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] vals = new int[n];
        int[] wts = new int[n];

        for (int i = 0; i < n; i++) {
            vals[i] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= wts[i - 1]) {
                    int rCap = j - wts[i - 1];

                    if ((dp[i - 1][rCap] + vals[i - 1]) > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][rCap] + vals[i - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j]; // when i doesn't bat
                    }
                } else {
                    dp[i][j] = dp[i - 1][j]; // when i doesn't bat
                }
            }
        }
        System.out.println(dp[n][cap]);
    }
}


/*
        Sample Input
        5
        15 14 10 45 30
        2 5 1 3 4
        7
        Sample Output
        75
*/
