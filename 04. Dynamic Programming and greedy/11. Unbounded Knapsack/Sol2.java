import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

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

        int[] dp = new int[cap + 1];
        for (int bagc = 1; bagc <= cap; bagc++) { //bag capacity
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (wts[i] <= bagc) {
                    int rbagc = bagc - wts[i];
                    int rbagv = dp[rbagc];
                    int tbagv = rbagv + vals[i];

                    if (tbagv > max) {
                        max = tbagv;
                    }
                }
            }
            dp[bagc] = max;
        }
        System.out.println(dp[cap]);
    }
}


/*
        Sample Input

        5
        15 14 10 45 30
        2 5 1 3 4
        7

        Sample Output

        100
*/
